package com.example.manageruniversity.core.auth;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
    void forgotPassword(String email);
    void changePassword(String oldPass, String newPass);
}
