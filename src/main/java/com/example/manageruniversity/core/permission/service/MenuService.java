package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.menu.Menu;
import com.example.manageruniversity.core.permission.domain.menu.MenuPermissionRequest;
import com.example.manageruniversity.core.permission.domain.menu.MenuRequest;
import com.example.manageruniversity.core.permission.domain.menu.UserMenuPermissionRequest;

import java.util.List;

public interface MenuService {
    Menu create(MenuRequest menuRequest);
    void assignMenuForPermission(MenuPermissionRequest request);
    void assignMenuPermissionForUser(UserMenuPermissionRequest request);
    void revokeMenuPermissionFromUser(UserMenuPermissionRequest request);
    void revokedMenuFromPermission(MenuPermissionRequest request);
    void revokedAllMenuFromPermission(Long permissionId);
    void deleteMenu(Long menuId);
    List<Menu> getAllMenu();
    Menu getByName(String name);
    Menu getById(Long id);
    List<Menu> getAllByPermissionId(Long permissionId);
}
