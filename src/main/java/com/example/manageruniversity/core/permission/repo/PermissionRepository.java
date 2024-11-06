package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
