package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.permission.Permission;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRequest;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRoleRequest;

import java.util.List;

public interface PermissionService {
    Permission createPermission(PermissionRequest request);
    Permission updatePermission(Long permissionId, PermissionRequest request);
    void deletePermission(Long id);
    List<Permission> getAll();
    List<Permission> getAllByRole(Long roleId);
    List<Permission> getAllByRole(String roleName);
    boolean roleHasPermission(String role, String permission);
    boolean roleHsAnyPermission(String role, String... permissions);
    void assignPermissionForRole(PermissionRoleRequest request);
    void revokePermissionFromRole(PermissionRoleRequest request);
    void revokePermissionFromRole(Long permissionRoleId);
}
