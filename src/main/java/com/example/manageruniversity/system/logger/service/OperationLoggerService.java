package com.example.manageruniversity.system.logger.service;

import com.example.manageruniversity.common.operatelog.dto.OperationLoggerCreateReqDTO;
import com.example.manageruniversity.common.pojo.PageResult;
import com.example.manageruniversity.system.logger.dal.dataobject.OperationLogger;

import java.util.concurrent.Future;

public interface OperationLoggerService {
    OperationLogger createOperationLogger(OperationLoggerCreateReqDTO reqDTO);

    PageResult<OperationLogger> getList(int page);
    void delete(Long operateLogId);

    default void deleteAll(Long[] operateLogIds) {
        for(Long operateLogId : operateLogIds) {
            delete(operateLogId);
        }
    }
}
