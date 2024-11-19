package com.example.manageruniversity.common.exception.constant;

import com.example.manageruniversity.common.exception.yu.ErrorCode;

public interface GlobalErrorCodeConstants {
    ErrorCode SUCCESS  = new ErrorCode(0, "Thanh cong");
    ErrorCode ERROR_INTERNAL_SERVER = new ErrorCode(1, "Loi server, vui long kiem tra lai");
}
