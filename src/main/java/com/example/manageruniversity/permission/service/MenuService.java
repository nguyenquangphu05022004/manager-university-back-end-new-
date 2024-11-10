package com.example.manageruniversity.permission.service;

import com.example.manageruniversity.permission.controller.dto.MenuDto;
import com.example.manageruniversity.permission.domain.entity.Menu;

public interface MenuService {
    Long create(MenuDto menuDto);
    Long update(MenuDto menuDto);
    void delete(Long id);
    Menu getByPermission(String permission);

}
