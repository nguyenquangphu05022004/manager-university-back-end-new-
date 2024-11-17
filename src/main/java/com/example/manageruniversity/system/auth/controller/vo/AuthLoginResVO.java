package com.example.manageruniversity.system.auth.controller.vo;

import com.example.manageruniversity.system.auth.dal.dataobject.AuthAccessToken;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AuthLoginResVO {
    private Long userId;
    private String fullName;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expires;

    public AuthLoginResVO(AuthAccessToken authAccessToken) {
        this.userId = authAccessToken.getUser().getId();
        this.fullName = authAccessToken.getUser().getFullName();
        this.accessToken = authAccessToken.getAccessToken();
        this.refreshToken = authAccessToken.getRefreshToken();
//        this.expires = authAccessToken.get
    }
}
