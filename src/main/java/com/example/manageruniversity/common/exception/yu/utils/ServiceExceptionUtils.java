package com.example.manageruniversity.common.exception.yu.utils;

import com.example.manageruniversity.common.exception.yu.ErrorCode;
import com.example.manageruniversity.common.exception.yu.ServiceException;

public class ServiceExceptionUtils {
    public static ServiceException exception(ErrorCode errorCode) {
        return new ServiceException(errorCode.getCode(), errorCode.getMessage());
    }

    public static ServiceException exception(ErrorCode errorCode, Object... params) {
        return exception(errorCode.getCode(), errorCode.getMessage(), params);
    }

    public static ServiceException exception(int code, String message, Object... params) {
        String messageFormat = null;
        return new ServiceException(code, messageFormat);
    }
}
