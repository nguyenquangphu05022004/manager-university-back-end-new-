package com.example.manageruniversity.web.security.service;

import com.example.manageruniversity.common.security.SecurityUtils;
import com.example.manageruniversity.core.permission.service.PermissionService;
import com.example.manageruniversity.core.permission.service.RoleService;
import com.example.manageruniversity.core.user.domain.entity.User;
import com.example.manageruniversity.core.user.domain.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ss")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService{

    private final  PermissionService permissionService;
    private final RoleService roleService;
    @Override
    public boolean hasRole(String role) {
        return false;
    }

    @Override
    public boolean hasAnyRole(String... roles) {
        return false;
    }

    @Override
    public boolean hasPermission(String permission) {
//        User loginUser = SecurityUtils.getLoginUser();
//        if(loginUser.getRole() == Role.SUPER_ADMIN) return true;
//        String words[] = permission.split(":");
        return true;
    }

    @Override
    public boolean hasAnyPermission(String... permissions) {
        return false;
    }
}
