package com.example.manageruniversity.common.excel.annotation;

import com.example.manageruniversity.common.excel.enums.TargetField;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation only use for field is single object.
 * Others are Map, List, Collection, ...etc, isn't supported
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelProperties {
    String column() default "";
    Class<?> targetObject() default Object.class;
    TargetField targetField() default TargetField.NORMAL;
}
