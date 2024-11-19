package com.example.manageruniversity.common.operatelog.dto;

import com.example.manageruniversity.common.operatelog.enums.OperateTypeEnum;
import lombok.Data;

import java.time.Duration;
import java.util.Date;

@Data
public class OperateLogCreateReqDTO {
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
    private Duration duration;

    private int resultCode;
    private String resultMessage;

}
