package com.example.manageruniversity.web.security.annotation;

public @interface Permission {
    String[] values() default "";
}
