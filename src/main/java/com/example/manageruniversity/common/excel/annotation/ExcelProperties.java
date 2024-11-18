package com.example.manageruniversity.common.excel.annotation;

import com.example.manageruniversity.common.excel.TargetField;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelProperties {
    String column() default "";
    Class<?> targetObject() default Object.class;
    TargetField targetField() default TargetField.NORMAL;
}
