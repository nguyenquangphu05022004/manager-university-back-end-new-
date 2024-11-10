package com.example.manageruniversity.permission.repo;

import com.example.manageruniversity.permission.domain.entity.MenuRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface MenuRoleRepository extends JpaRepository<MenuRole, Long> {
    List<MenuRole> findAllByMenuId(Long menuId);

    @Modifying
    void deleteAllByRoleId(Long roleId);

    @Modifying
    void deleteAllByMenuId(Long menuId);
}
