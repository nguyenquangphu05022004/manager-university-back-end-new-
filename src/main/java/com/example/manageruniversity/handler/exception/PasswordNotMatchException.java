package com.example.manageruniversity.handler.exception;

public class PasswordNotMatchException extends RuntimeException{
    public PasswordNotMatchException(String message) {
        super(message);
    }
}
