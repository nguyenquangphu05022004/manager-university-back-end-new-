package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.role.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<RoleUser, Long> {
}
