package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
