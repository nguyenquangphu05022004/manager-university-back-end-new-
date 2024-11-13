package com.example.manageruniversity.core.auth;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
    void logout();
    void refreshToken();
}
