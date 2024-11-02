package com.example.manageruniversity.common.exception.constant;

import com.example.manageruniversity.common.exception.MessageException;
import org.springframework.http.HttpStatus;

public interface AuthServiceExceptionConstant {
    MessageException USERNAME_NOT_FOUND = new MessageException(HttpStatus.NOT_FOUND, "Username not found");
    MessageException PASSWORD_NOT_FOUND_OR_MATCH = new MessageException(HttpStatus.NOT_FOUND, "Password not found or match");
    MessageException EMAIL_NOT_FOUND = new MessageException(HttpStatus.NOT_FOUND, "Email not found");
    MessageException TOKEN_NOT_FOUND_OR_EXPIRED = new MessageException(HttpStatus.NOT_FOUND, "Token not found or was expired");
}
