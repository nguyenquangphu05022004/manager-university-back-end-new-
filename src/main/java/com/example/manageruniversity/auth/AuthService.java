package com.example.manageruniversity.auth;

import com.example.manageruniversity.user.domain.enums.Role;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
    void forgotPassword(String email);
    void changePassword(String oldPass, String newPass);
}
