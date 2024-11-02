package com.example.manageruniversity.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class MessageException extends RuntimeException{
    private HttpStatus code;
    private String message;
}
