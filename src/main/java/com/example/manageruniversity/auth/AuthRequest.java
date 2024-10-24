package com.example.manageruniversity.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
