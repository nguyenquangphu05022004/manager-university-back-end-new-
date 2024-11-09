package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.menu.UserMenuPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMenuPermissionRepository extends JpaRepository<UserMenuPermission, Long> {
    void deleteByUserIdAndMenuPermissionId(Long userId, Long menuPermissionId);
//    Optional<UserMenuPermission> findByUserIdAndPermissionNameAndMenuAction(
//            Long userId,
//            String permissionId,
//
//    )
}
