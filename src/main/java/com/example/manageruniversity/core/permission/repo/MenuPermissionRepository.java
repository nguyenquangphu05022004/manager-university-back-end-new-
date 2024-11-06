package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.menu.MenuPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuPermissionRepository extends JpaRepository<MenuPermission, Long> {
}
