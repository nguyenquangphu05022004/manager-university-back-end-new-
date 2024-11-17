package com.example.manageruniversity.system.permission.repo;

import com.example.manageruniversity.system.permission.domain.entity.Role;
import com.example.manageruniversity.system.permission.domain.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    void deleteByUserIdAndRoleId(Long userId, Long roleId);
    Optional<Role> findByUserIdAndRoleName(Long userId, String roleName);

    @Modifying
    void deleteAllByRoleId(Long roleId);
}
