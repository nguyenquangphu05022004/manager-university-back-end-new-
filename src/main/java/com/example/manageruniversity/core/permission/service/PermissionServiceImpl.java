package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.permission.Permission;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRequest;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRoleRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{
    @Override
    public Permission createPermission(PermissionRequest request) {
        return null;
    }

    @Override
    public Permission updatePermission(Long permissionId, PermissionRequest request) {
        return null;
    }

    @Override
    public void deletePermission(Long id) {

    }

    @Override
    public List<Permission> getAll() {
        return null;
    }

    @Override
    public List<Permission> getAllByRole(Long roleId) {
        return null;
    }

    @Override
    public List<Permission> getAllByRole(String roleName) {
        return null;
    }

    @Override
    public boolean hasPermission(String permission) {
        return false;
    }

    @Override
    public boolean hasAnyPermission(String... permission) {
        return false;
    }

    @Override
    public void assignPermissionForRole(PermissionRoleRequest request) {

    }

    @Override
    public void revokePermissionFromRole(PermissionRoleRequest request) {

    }
}
