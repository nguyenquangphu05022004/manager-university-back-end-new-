package com.example.manageruniversity.system.auth.service;

import com.example.manageruniversity.system.auth.controller.vo.AuthLoginReqVO;
import com.example.manageruniversity.system.auth.controller.vo.AuthLoginResVO;

public interface AuthService {
    AuthLoginResVO login(AuthLoginReqVO reqVO);
    void logout(String accessToken);
    AuthLoginResVO refreshToken(String refreshToken);
}
