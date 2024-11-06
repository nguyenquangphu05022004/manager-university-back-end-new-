package com.example.manageruniversity.web.security.service;

public interface SecurityService {
    boolean hasRole(String role);
    boolean hasAnyRole(String... roles);
    boolean hasPermission(String permission);
    boolean hasAnyPermission(String... permissions);
}
