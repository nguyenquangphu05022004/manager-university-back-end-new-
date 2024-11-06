package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.role.Role;
import com.example.manageruniversity.core.permission.domain.role.RoleUserRequest;
import com.example.manageruniversity.core.permission.domain.role.RoleRequest;

import java.util.List;

public interface RoleService {
    Role createRole(RoleRequest request);
    Role updateRole(Long roleId, RoleRequest request);
    void deleteById(Long roleId);
    void deleteByName(String roleName);
    List<Role> getAllRole();
    List<Role> getAllRoleByUser(Long userId);
    List<Role> getAllRoleByUser(String username);
    void assignRoleForUser(RoleUserRequest request);
    void revokeRoleFromUser(RoleUserRequest request);
    boolean hasRole(String role);
    boolean hasAnyRole(String... roles);
}
