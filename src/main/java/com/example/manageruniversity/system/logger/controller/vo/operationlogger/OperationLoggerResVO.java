package com.example.manageruniversity.system.logger.controller.vo.operationlogger;

import com.example.manageruniversity.common.operatelog.enums.OperateTypeEnum;
import com.example.manageruniversity.system.logger.dal.dataobject.OperationLogger;
import lombok.Data;

import java.util.Date;

@Data
public class OperationLoggerResVO {
    private Long id;
    private Long userId;
    private String username;


    private String methodName;
    /**
     * Describe what method do.
     */
    private String description;
    /**
     * @link common.operatelog.enums.OperateTypeEnum
     */
    private OperateTypeEnum operateTypeEnum;

    /**
     * Result if it is enabled log.
     * Write object under json.
     */
    private String result;

    /**
     * Write args under JSON,  if is enabled log.
     */
    private String args;

    private String clientId;

    private String userAgent;


    private Date startLog;
//    private Duration duration;

    private int resultCode;
    private String resultMessage;


    public OperationLoggerResVO(OperationLogger operationLogger) {
        setId(operationLogger.getId());
        setClientId(operationLogger.getClientIp());
        setUserAgent(operationLogger.getUserAgent());
        setUsername(operationLogger.getUsername());
        setUserId(operationLogger.getUserId());
        setResult(operationLogger.getResult());
        setResultCode(operationLogger.getResultCode());
        setResultMessage(operationLogger.getResultMessage());
        setMethodName(operationLogger.getMethodName());
        setDescription(operationLogger.getDescription());
        setOperateTypeEnum(operationLogger.getOperateTypeEnum());
        setArgs(operationLogger.getArgs());
        setStartLog(operationLogger.getStartLog());
    }
}
