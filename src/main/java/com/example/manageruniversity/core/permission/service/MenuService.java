package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.menu.Menu;
import com.example.manageruniversity.core.permission.domain.menu.MenuPermissionRequest;
import com.example.manageruniversity.core.permission.domain.menu.MenuRequest;
import com.example.manageruniversity.core.permission.domain.menu.UserMenuPermissionRequest;

import java.util.List;

public interface MenuService {
    /**
     * Tao menu
     * @param menuRequest
     * @return
     */
    Menu create(MenuRequest menuRequest);

    /**
     * Gan menu cho permission
     * @param request
     */
    void assignMenuForPermission(MenuPermissionRequest request);

    /**
     * Gan menuPermission cho user
     * @param request
     */
    void assignMenuPermissionForUser(UserMenuPermissionRequest request);

    /**
     * Xoa bo menuPermission tu user
     * @param request
     */
    void revokeMenuPermissionFromUser(UserMenuPermissionRequest request);

    /**
     * xoa bo menu tu permission
     * @param request
     */
    void revokedMenuFromPermission(MenuPermissionRequest request);

    /**
     * Xoa bo toan bo menu tu permission
     * @param permissionId
     */
    void revokedAllMenuFromPermission(Long permissionId);

    /**
     * xoa menu boi id
     * @param menuId
     */
    void deleteMenu(Long menuId);
    List<Menu> getAllMenu();
    Menu getByName(String name);
    Menu getById(Long id);

    /**
     * Lay toan bo menu duoc gan cho permission
     * @param permissionId
     * @return
     */
    List<Menu> getAllByPermissionId(Long permissionId);
}
