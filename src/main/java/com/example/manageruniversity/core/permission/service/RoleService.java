package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.role.Role;
import com.example.manageruniversity.core.permission.domain.role.RoleUserRequest;
import com.example.manageruniversity.core.permission.domain.role.RoleRequest;

import java.util.List;

public interface RoleService {
    Role createRole(RoleRequest request);
    Role updateRole(Long roleId, RoleRequest request);
    void deleteById(Long roleId);
    List<Role> getAllRole();
    List<Role> getAllRoleByUser(Long userId);
    void assignRoleForUser(RoleUserRequest request);
    void revokeRoleFromUser(RoleUserRequest request);
    boolean userHasRole(Long userId, String role);
    boolean userHasAnyRole(Long userId, String... roles);
}
