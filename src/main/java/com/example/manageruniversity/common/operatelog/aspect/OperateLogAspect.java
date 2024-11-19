package com.example.manageruniversity.common.operatelog.aspect;

import com.example.manageruniversity.common.exception.constant.GlobalErrorCodeConstants;
import com.example.manageruniversity.common.json.JsonUtils;
import com.example.manageruniversity.common.operatelog.annotation.OperateLog;
import com.example.manageruniversity.common.operatelog.dto.OperateLogCreateReqDTO;
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
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static com.example.manageruniversity.common.exception.constant.GlobalErrorCodeConstants.*;

@Aspect
@RequiredArgsConstructor
@Component
public class OperateLogAspect {

    private final OperationLoggerService operateFrameworkLogService;


    @Around("@annotation(operateLog)")
    public Object around(ProceedingJoinPoint joinPoint,  OperateLog operateLog) throws Throwable {
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
        if(operateLog.enable()) return;
        OperateLogCreateReqDTO operateLogCreateReqDTO = new OperateLogCreateReqDTO();
        operateLogCreateReqDTO.setDescription(operateLog.describe());

        /**
         * Set info user
         */
        fillUserField(operateLogCreateReqDTO);

        /**
         * method name
         */
        operateLogCreateReqDTO.setMethodName(joinPoint.getSignature().getName());
        operateLogCreateReqDTO.setOperateTypeEnum(operateLog.type());

        if(result != null) {
            if(result instanceof CommonResult<?>) {
                CommonResult<?> commonResult = (CommonResult<?>) result;
                operateLogCreateReqDTO.setResultMessage(commonResult.getMessage());
                operateLogCreateReqDTO.setResultCode(commonResult.getCode());
                if(operateLog.logResult()) {
                    operateLogCreateReqDTO.setResult(JsonUtils.write(commonResult.getData()));
                }
            } else {
                operateLogCreateReqDTO.setResultCode(SUCCESS.getCode());
            }

        }
        if(operateLog.logArgs()) {
            operateLogCreateReqDTO.setArgs(obtainMethodArgs(joinPoint));
        }

        if(e != null) {
            operateLogCreateReqDTO.setResultCode(ERROR_INTERNAL_SERVER.getCode());
            operateLogCreateReqDTO.setResultMessage(ERROR_INTERNAL_SERVER.getMessage());
        }


        /**
         * Save log
         */
        this.operateFrameworkLogService.createOperationLogger(operateLogCreateReqDTO);

    }

    private  void fillUserField(OperateLogCreateReqDTO operateLogCreateReqDTO) {
        Long userId = SecurityUtils.getLoginUserId();
        String username = SecurityUtils.getLoginUserUsername();
        operateLogCreateReqDTO.setUsername(username);
        operateLogCreateReqDTO.setUserId(userId);
        operateLogCreateReqDTO.setClientId(ServletUtils.getIpClient());
        operateLogCreateReqDTO.setUserAgent(ServletUtils.getUserAgent());
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
