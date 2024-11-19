package com.example.manageruniversity.common.operatelog.aspect;

import com.example.manageruniversity.common.json.JsonUtils;
import com.example.manageruniversity.common.operatelog.annotation.OperateLog;
import com.example.manageruniversity.common.operatelog.dto.OperationLoggerCreateReqDTO;
import com.example.manageruniversity.common.operatelog.enums.OperateTypeEnum;
import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.servlet.ServletUtils;
import com.example.manageruniversity.security.utils.SecurityUtils;
import com.example.manageruniversity.system.logger.service.OperationLoggerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static com.example.manageruniversity.common.exception.constant.GlobalErrorCodeConstants.ERROR_INTERNAL_SERVER;
import static com.example.manageruniversity.common.exception.constant.GlobalErrorCodeConstants.SUCCESS;

@Aspect
@RequiredArgsConstructor
@Component
public class OperateLogAspect {

    private final OperationLoggerService operateFrameworkLogService;


    @Around("@annotation(operateLog)")
    public Object around(ProceedingJoinPoint joinPoint,  OperateLog operateLog) throws Throwable {
        System.out.println("log operate");
        Date startTime = new Date();
        try {
            Object result = joinPoint.proceed();
            log(joinPoint, operateLog,startTime , result, null);
            return result;
        }
        catch (Throwable e) {
            log(joinPoint, operateLog, startTime, null, e);
            throw e;
        }
    }


    private void log(ProceedingJoinPoint joinPoint,
                            OperateLog operateLog,
                            Date startTime,
                            Object result,
                            Throwable e) {
        if(!operateLog.enable()) return;
        OperationLoggerCreateReqDTO operationLogCreateReqDTO = new OperationLoggerCreateReqDTO();
        operationLogCreateReqDTO.setDescription(operateLog.describe());
        operationLogCreateReqDTO.setStartLog(startTime);

        /**
         * Set info user
         */
        fillUserField(operationLogCreateReqDTO);

        /**
         * method name
         */
        operationLogCreateReqDTO.setMethodName(joinPoint.getSignature().getName());
        operationLogCreateReqDTO.setOperateTypeEnum(obtainOperateType(joinPoint, operateLog));

        if(result != null) {
            if(result instanceof CommonResult<?>) {
                CommonResult<?> commonResult = (CommonResult<?>) result;
                operationLogCreateReqDTO.setResultMessage(commonResult.getMessage());
                operationLogCreateReqDTO.setResultCode(commonResult.getCode());
                if(operateLog.logResult()) {
                    operationLogCreateReqDTO.setResult(JsonUtils.write(commonResult.getData()));
                }
            } else {
                operationLogCreateReqDTO.setResultCode(SUCCESS.getCode());
            }

        }
        if(operateLog.logArgs()) {
            operationLogCreateReqDTO.setArgs(obtainMethodArgs(joinPoint));
        }

        if(e != null) {
            operationLogCreateReqDTO.setResultCode(ERROR_INTERNAL_SERVER.getCode());
            operationLogCreateReqDTO.setResultMessage(ERROR_INTERNAL_SERVER.getMessage());
        }


        /**
         * Save log
         */
        this.operateFrameworkLogService.createOperationLogger(operationLogCreateReqDTO);

    }

    private OperateTypeEnum obtainOperateType(ProceedingJoinPoint joinPoint, OperateLog operateLog) {
        RequestMapping annotation = AnnotationUtils.getAnnotation(((MethodSignature) (joinPoint.getSignature())).getMethod(), RequestMapping.class);
        if(annotation == null) {
            return operateLog.type();
        }
        RequestMethod[] method = annotation.method();
        return switch (method[0]){
            case GET  -> OperateTypeEnum.GET;
            case POST -> OperateTypeEnum.CREATE;
            case DELETE ->  OperateTypeEnum.DELETE;
            case PUT -> OperateTypeEnum.UPDATE;
            default -> OperateTypeEnum.OTHER;
        };
    }

    private  void fillUserField(OperationLoggerCreateReqDTO operationLogCreateReqDTO) {
        Long userId = SecurityUtils.getLoginUserId();
        String username = SecurityUtils.getLoginUserUsername();
        operationLogCreateReqDTO.setUsername(username);
        operationLogCreateReqDTO.setUserId(userId);
        operationLogCreateReqDTO.setClientId(ServletUtils.getIpClient());
        operationLogCreateReqDTO.setUserAgent(ServletUtils.getUserAgent());
    }



    private  String obtainMethodArgs(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] argsNames = signature.getParameterNames();
        Object[] argsValues = joinPoint.getArgs();

        Map<String, Object> map = new HashMap<>(argsValues.length);
        for(int i = 0; i < argsNames.length; i++) {
            map.put(argsNames[i], !ignoreValues(argsValues[i]) ? argsValues[i] : "[ignore]");
        }

        return JsonUtils.write(map);
    }

    private  boolean ignoreValues(Object object) {
        Class<?> clazz = object.getClass();
        /**
         * Ignore array if contains some object is ignored itself.
         */
        if(clazz.isArray()) {
            return IntStream.range(0, Array.getLength(object))
                    .anyMatch(index -> ignoreValues(Array.get(object, index)));
        }
        /**
         * Ignore collection if contains some object is ignored itself.
         */
        if(Collection.class.isAssignableFrom(clazz)) {
            return ((Collection)object).stream()
                    .anyMatch(s -> ignoreValues(s));
        }

        /**
         * Ignore map if contains some object is ignored itself.
          */
        if(clazz.isAssignableFrom(Map.class)) {
            return ignoreValues(((Map<?, ?>)object).values());
        }

        /**
         * Ignore instance of Multipart, ...
         */
        return object instanceof MultipartFile
                || object instanceof HttpServletRequest
                || object instanceof HttpServletResponse
                || object instanceof BindingResult;
    }
}
