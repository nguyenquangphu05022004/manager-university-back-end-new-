package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.permission.PermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

public interface PermissionRoleRepository extends JpaRepository<PermissionRole, Long> {
   @Modifying
    void deleteAllByPermissionId(Long permissionId);

    List<PermissionRole> findAllByRoleId(Long roleId);

    List<PermissionRole> findAllByRoleName(String roleName);

    Optional<PermissionRole> findByRoleNameAndPermissionName(String role, String permission);

    @Modifying
    void deleteByPermissionIdAndRoleId(Long permissionId, Long roleId);
}
