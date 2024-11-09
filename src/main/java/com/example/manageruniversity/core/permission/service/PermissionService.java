package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.menu.Menu;
import com.example.manageruniversity.core.permission.domain.permission.Permission;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRequest;

import java.util.List;

public interface PermissionService {
    Permission createPermission(PermissionRequest request);
    Permission updatePermission(Long permissionId, PermissionRequest request);
    void deletePermission(Long id);
    List<Permission> getAll();
    boolean permissionHasMenuAction(String permission, Menu.Action action);

    boolean userHasPermissionAndMenuAction(Long userId, String permission, Menu.Action action);
}
