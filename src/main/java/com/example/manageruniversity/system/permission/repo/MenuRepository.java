package com.example.manageruniversity.system.permission.repo;

import com.example.manageruniversity.system.permission.domain.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByName(String name);

    Optional<Menu> findByPermission(String permission);
}
