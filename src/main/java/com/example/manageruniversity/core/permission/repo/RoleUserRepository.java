package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.role.Role;
import com.example.manageruniversity.core.permission.domain.role.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    void deleteByUserIdAndRoleId(Long userId, Long roleId);
    Optional<Role> findByUserIdAndRoleName(Long userId, String roleName);
}
