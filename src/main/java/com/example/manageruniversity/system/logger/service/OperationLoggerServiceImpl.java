package com.example.manageruniversity.system.logger.service;

import com.example.manageruniversity.common.operatelog.dto.OperationLoggerCreateReqDTO;
import com.example.manageruniversity.common.pojo.PageConstant;
import com.example.manageruniversity.common.pojo.PageResult;
import com.example.manageruniversity.system.logger.dal.dataobject.OperationLogger;
import com.example.manageruniversity.system.logger.dal.repo.OperationLoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationLoggerServiceImpl implements OperationLoggerService{
    private final OperationLoggerRepository operationLoggerRepository;

    @Override
    public OperationLogger createOperationLogger(OperationLoggerCreateReqDTO reqDTO) {
//        return Executors.newCachedThreadPool().submit(() -> {
            OperationLogger operationLogger = new OperationLogger();
            operationLogger.setArgs(reqDTO.getArgs());
            operationLogger.setOperateTypeEnum(reqDTO.getOperateTypeEnum());
            operationLogger.setResult(reqDTO.getResult());
            operationLogger.setResultCode(reqDTO.getResultCode());
            operationLogger.setMethodName(reqDTO.getMethodName());
            operationLogger.setResultMessage(reqDTO.getResultMessage());
            operationLogger.setClientIp(reqDTO.getClientId());
            operationLogger.setStartLog(reqDTO.getStartLog());
            operationLogger.setUserAgent(reqDTO.getUserAgent());
            operationLogger.setUsername(reqDTO.getUsername());
            operationLogger.setDescription(reqDTO.getDescription());
            operationLogger.setUserId(reqDTO.getUserId());
            this.operationLoggerRepository.save(operationLogger);
           return operationLogger;
//        });
    }

    @Override
    public PageResult<OperationLogger> getList(int page) {
        Page<OperationLogger> pageResult = this.operationLoggerRepository
                .findAll(PageRequest.of(page - 1, PageConstant.LIMIT));
        return new PageResult<>(pageResult);
    }

    @Override
    public void delete(Long operateLogId) {
        this.operationLoggerRepository.deleteById(operateLogId);
    }
}
