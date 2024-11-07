package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.menu.UserMenuPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMenuPermissionRepository extends JpaRepository<UserMenuPermission, Long> {
    void deleteByUserIdAndMenuPermissionId(Long userId, Long menuPermissionId);
}
