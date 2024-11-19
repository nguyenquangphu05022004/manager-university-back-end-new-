package com.example.manageruniversity.system.logger.dal.dataobject;


import com.example.manageruniversity.common.base.SubBaseEntity;
import com.example.manageruniversity.common.operatelog.enums.OperateTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "sys_operation_logger")
@Entity
@Data
@NoArgsConstructor
public class OperationLogger extends SubBaseEntity {

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
    @Enumerated(EnumType.STRING)
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

    private String clientIp;

    private String userAgent;


    private Date startLog;
//    private Duration duration;

    private int resultCode;
    private String resultMessage;

}
