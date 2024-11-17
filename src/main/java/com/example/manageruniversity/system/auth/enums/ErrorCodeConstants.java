package com.example.manageruniversity.system.auth.enums;

import com.example.manageruniversity.common.exception.yu.ErrorCode;

public interface ErrorCodeConstants {

    //============Authentication================
    ErrorCode USERNAME_NOT_FOUND = new ErrorCode(404, "Khong tim thay username");
    ErrorCode PASSWORD_NOT_FOUND = new ErrorCode(404, "Mat khau khong chinh xac");

    //==========Auth Access Token================
    ErrorCode ACCESS_TOKEN_NOT_FOUND = new ErrorCode(404, "Khong tim thay access token");
    ErrorCode ACCESS_TOKEN_IS_EXPIRED = new ErrorCode(400, "Access token bi het han");
    ErrorCode REFRESH_TOKEN_NOT_FOUND = new ErrorCode(404, "Refresh token khong tim thay");

}
