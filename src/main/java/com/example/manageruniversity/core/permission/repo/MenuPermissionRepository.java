package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.menu.MenuPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface MenuPermissionRepository extends JpaRepository<MenuPermission, Long> {
    @Modifying
    void deleteByPermissionIdAndMenuId(Long permissionId, Long menuId);
    @Modifying
    void deleteAllByMenuId(Long menuId);
    List<MenuPermission> findAllByPermissionId(Long permissionId);

    @Modifying
    void deleteAllByPermissionId(Long permissionId);
}
