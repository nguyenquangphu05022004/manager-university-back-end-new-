package com.example.manageruniversity.auth;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String refreshToken;
    private Long expired;
}
