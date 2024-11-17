package com.example.manageruniversity.system.permission.service;

import com.example.manageruniversity.system.permission.domain.entity.MenuRole;

import java.util.Set;

public interface PermissionService {
    boolean hasAnyPermission(Long userId, String... permissions);
    void assignRoleForUser(Long userId, Set<Long> roleIds);
    void assignMenuForRole(Long roleId, Set<Long> menuIds);

    /**
     * Lay toan bo role duoc gan vao menu
     * @param menuId: id menu
     * @return Tap cac id cua role
     */
    Set<MenuRole> getAllMenuRoleByMenuId(Long menuId);

    void processDeleteRole(Long roleId);
    void processDeleteMenu(Long menuId);

}
