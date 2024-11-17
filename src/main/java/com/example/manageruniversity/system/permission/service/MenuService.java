package com.example.manageruniversity.system.permission.service;

import com.example.manageruniversity.system.permission.controller.dto.MenuDto;
import com.example.manageruniversity.system.permission.domain.entity.Menu;

public interface MenuService {
    Long create(MenuDto menuDto);
    Long update(MenuDto menuDto);
    void delete(Long id);
    Menu getByPermission(String permission);

}
