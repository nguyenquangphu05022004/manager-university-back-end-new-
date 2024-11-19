package com.example.manageruniversity.system.logger.dal.dataobject;


import com.example.manageruniversity.common.base.SubBaseEntity;
import com.example.manageruniversity.common.operatelog.enums.OperateTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<OperateTypeEnum> operateTypeEnums;

    /**
     * Result if it is enabled log.
     * Write object under json.
     */
    private String result;

    /**
     * Write args under JSON,  if is enabled log.
     */
    private List<String> args;


    public OperationLogger(Long userId,
                           String username,
                           String methodName,
                           String description,
                           List<OperateTypeEnum> operateTypeEnums,
                           String result,
                           List<String> args) {
        this.userId = userId;
        this.username = username;
        this.methodName = methodName;
        this.description = description;
        this.operateTypeEnums = operateTypeEnums;
        this.result = result;
        this.args = args;
    }
}
