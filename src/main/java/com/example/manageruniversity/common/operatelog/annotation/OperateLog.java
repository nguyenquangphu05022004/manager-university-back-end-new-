package com.example.manageruniversity.common.operatelog.annotation;


import com.example.manageruniversity.common.operatelog.enums.OperateTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This method for specific what method need to log.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateLog {
    /**
     * What method to need?
     * @return
     */
    String describe() default "";

    /**
     * Allow log or not
     * @return
     */
    boolean enable() default true;

    /**
     *Type of operate
     */
    OperateTypeEnum type() default OperateTypeEnum.OTHER;


    /**
     * Log parameter is passed through method(in controller)
     * @return
     */
    boolean logArgs() default true;

    /**
     * Log result after task completed
     * @return: true is log result else not
     */
    boolean logResult() default false;

}
