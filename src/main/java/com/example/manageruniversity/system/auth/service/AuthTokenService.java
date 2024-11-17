package com.example.manageruniversity.system.auth.service;

import com.example.manageruniversity.system.auth.dal.dataobject.AuthAccessToken;

public interface AuthTokenService {

    AuthAccessToken createAccessToken(Long userid);
    AuthAccessToken refreshAccessToken(String refreshToken);
    AuthAccessToken getAccessToken(String accessToken);
    AuthAccessToken checkAccessToken(String accessToken);
    AuthAccessToken removeAccessToken(String accessToken);
}
