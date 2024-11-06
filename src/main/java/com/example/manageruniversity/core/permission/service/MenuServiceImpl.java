package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.core.permission.domain.menu.Menu;
import com.example.manageruniversity.core.permission.domain.menu.MenuPermissionRequest;
import com.example.manageruniversity.core.permission.domain.menu.MenuRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Override
    public Menu create(MenuRequest menuRequest) {
        return null;
    }

    @Override
    public void assignMenuForPermission(MenuPermissionRequest request) {

    }

    @Override
    public void revokedMenuFromPermission(MenuPermissionRequest request) {

    }

    @Override
    public void deleteMenu(Long menuId) {

    }

    @Override
    public List<Menu> getAllMenu() {
        return null;
    }

    @Override
    public Menu getByName(String name) {
        return null;
    }

    @Override
    public Menu getById(Long id) {
        return null;
    }

    @Override
    public List<Menu> getAllByPermission(Long permissionId) {
        return null;
    }

    @Override
    public List<Menu> getAllByPermission(String permissionName) {
        return null;
    }
}
