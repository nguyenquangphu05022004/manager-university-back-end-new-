package com.example.manageruniversity.core.permission.repo;

import com.example.manageruniversity.core.permission.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByName(String name);
}
