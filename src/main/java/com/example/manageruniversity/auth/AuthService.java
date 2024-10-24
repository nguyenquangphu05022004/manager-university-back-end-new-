package com.example.manageruniversity.auth;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
}
