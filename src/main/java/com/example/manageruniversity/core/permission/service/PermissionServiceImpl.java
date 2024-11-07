package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.permission.domain.permission.Permission;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRequest;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRole;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRoleRequest;
import com.example.manageruniversity.core.permission.domain.role.Role;
import com.example.manageruniversity.core.permission.repo.MenuPermissionRepository;
import com.example.manageruniversity.core.permission.repo.PermissionRepository;
import com.example.manageruniversity.core.permission.repo.PermissionRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService{
    private final PermissionRepository permissionRepository;
    private final PermissionRoleRepository permissionRoleRepository;
    private final MenuPermissionRepository menuPermissionRepository;
    @Override
    public Permission createPermission(PermissionRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        Permission permission = new Permission(request.getName());
        this.permissionRepository.save(permission);
        return permission;
    }

    @Override
    public Permission updatePermission(Long permissionId, PermissionRequest request) {
        Permission permission = this.permissionRepository
                .findById(permissionId)
                .orElseThrow(() -> new ResourcesNotFoundException("permission not found"));
        permission.setName(request.getName());
        this.permissionRepository.save(permission);
        return permission;
    }

    @Override
    @Transactional
    public void deletePermission(Long id) {
        this.menuPermissionRepository.deleteAllByPermissionId(id);
        this.permissionRoleRepository.deleteAllByPermissionId(id);
        this.permissionRepository.deleteById(id);
    }

    @Override
    public List<Permission> getAll() {
        return this.permissionRepository.findAll();
    }

    @Override
    public List<Permission> getAllByRole(Long roleId) {
        return ListUtils.convert(
                this.permissionRoleRepository.findAllByRoleId(roleId),
                s -> s.getPermission());
    }

    @Override
    public List<Permission> getAllByRole(String roleName) {
        return ListUtils.convert(
                this.permissionRoleRepository.findAllByRoleName(roleName),
                s -> s.getPermission());
    }

    @Override
    public boolean roleHasPermission(String role, String permission) {
        return this.permissionRoleRepository
                .findByRoleNameAndPermissionName(role, permission)
                .isPresent();
    }

    @Override
    public boolean roleHsAnyPermission(String role, String... permissions) {
        for(String permission : permissions) {
            return roleHasPermission(role, permission);
        }
        return false;
    }


    @Override
    public void assignPermissionForRole(PermissionRoleRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        PermissionRole permissionRole = new PermissionRole(
                new Permission(request.getPermissionId()),
                new Role(request.getRoleId())
        );
        this.permissionRoleRepository.save(permissionRole);
    }

    @Override
    public void revokePermissionFromRole(PermissionRoleRequest request) {
        this.permissionRoleRepository.deleteByPermissionIdAndRoleId(
                request.getPermissionId(),
                request.getRoleId()
        );
    }

    @Override
    public void revokePermissionFromRole(Long permissionRoleId) {
        this.permissionRoleRepository.deleteById(permissionRoleId);
    }
}
