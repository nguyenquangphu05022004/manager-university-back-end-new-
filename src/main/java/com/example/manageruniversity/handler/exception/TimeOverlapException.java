package com.example.manageruniversity.handler.exception;

public class TimeOverlapException extends RuntimeException{
    public TimeOverlapException(String message) {
        super(message);
    }
}
