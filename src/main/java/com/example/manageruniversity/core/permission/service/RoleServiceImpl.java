package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.role.Role;
import com.example.manageruniversity.core.permission.domain.role.RoleRequest;
import com.example.manageruniversity.core.permission.domain.role.RoleUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Override
    public Role createRole(RoleRequest request) {
        return null;
    }

    @Override
    public Role updateRole(Long roleId, RoleRequest request) {
        return null;
    }

    @Override
    public void deleteById(Long roleId) {

    }

    @Override
    public void deleteByName(String roleName) {

    }

    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public List<Role> getAllRoleByUser(Long userId) {
        return null;
    }

    @Override
    public List<Role> getAllRoleByUser(String username) {
        return null;
    }

    @Override
    public void assignRoleForUser(RoleUserRequest request) {

    }

    @Override
    public void revokeRoleFromUser(RoleUserRequest request) {

    }

    @Override
    public boolean hasRole(String role) {
        return false;
    }

    @Override
    public boolean hasAnyRole(String... roles) {
        return false;
    }
}
