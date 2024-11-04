package com.example.manageruniversity.web.security.service;

public interface SecurityService {
    boolean hasRole(String... roles);
    boolean hasAnyRole(String... roles);
    boolean hasPermission(String... permissions);
    boolean hasAnyPermission(String... permissions);
}
