package com.example.manageruniversity.exception;

public class ObjectExistException extends RuntimeException{
    public ObjectExistException(String message) {
        super(message);
    }
}
