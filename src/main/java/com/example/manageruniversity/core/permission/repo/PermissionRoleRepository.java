package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.permission.PermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRoleRepository extends JpaRepository<PermissionRole, Long> {
}
