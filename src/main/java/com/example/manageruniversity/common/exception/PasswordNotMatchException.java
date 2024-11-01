package com.example.manageruniversity.common.exception;

public class PasswordNotMatchException extends RuntimeException{
    public PasswordNotMatchException(String msg) {
        super(msg);
    }
}
