package com.example.manageruniversity.system.logger.service;

import com.example.manageruniversity.common.operatelog.dto.OperateLogCreateReqDTO;
import com.example.manageruniversity.common.pojo.PageResult;
import com.example.manageruniversity.system.logger.dal.dataobject.OperationLogger;
import com.example.manageruniversity.system.logger.dal.repo.OperationLoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class OperationLoggerServiceImpl implements OperationLoggerService{
    private final OperationLoggerRepository operationLoggerRepository;

    @Override
    public Future<OperationLogger> createOperationLogger(OperateLogCreateReqDTO reqDTO) {
        return Executors.newCachedThreadPool().submit(() -> {
//           OperationLogger operationLogger = new OperationLogger(
//                   reqDTO.getUserId(), reqDTO.getUsername(),
//                   reqDTO.getMethodName(), reqDTO.getDescription(),
//                   reqDTO.getOperateTypeEnums(), reqDTO.getResult(),
//                   reqDTO.getArgs()
//           );
//           return operationLogger;
            return null;
        });
    }

    @Override
    public PageResult<OperationLogger> getList() {
        return null;
    }

    @Override
    public void delete(Long operateLogId) {

    }
}
