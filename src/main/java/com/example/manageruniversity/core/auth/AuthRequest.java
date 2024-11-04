package com.example.manageruniversity.core.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
