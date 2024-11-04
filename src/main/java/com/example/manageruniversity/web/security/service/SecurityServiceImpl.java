package com.example.manageruniversity.web.security.service;

import org.springframework.stereotype.Service;

@Service("ss")
public class SecurityServiceImpl implements SecurityService{
    @Override
    public boolean hasRole(String... roles) {
        return false;
    }

    @Override
    public boolean hasAnyRole(String... roles) {
        return false;
    }

    @Override
    public boolean hasPermission(String... permissions) {
        return false;
    }

    @Override
    public boolean hasAnyPermission(String... permissions) {
        return false;
    }
}
