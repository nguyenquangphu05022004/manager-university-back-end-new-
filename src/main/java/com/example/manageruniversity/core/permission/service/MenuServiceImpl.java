package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.permission.domain.menu.*;
import com.example.manageruniversity.core.permission.domain.permission.Permission;
import com.example.manageruniversity.core.permission.repo.MenuPermissionRepository;
import com.example.manageruniversity.core.permission.repo.MenuRepository;
import com.example.manageruniversity.core.permission.repo.UserMenuPermissionRepository;
import com.example.manageruniversity.core.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;
    private final MenuPermissionRepository menuPermissionRepository;
    private final UserMenuPermissionRepository userMenuPermissionRepository;
    @Override
    public Menu create(MenuRequest menuRequest) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(menuRequest);
        Menu menu = new Menu(menuRequest.getName(), menuRequest.getAction());
        this.menuRepository.save(menu);
        return menu;
    }

    @Override
    public void assignMenuForPermission(MenuPermissionRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        MenuPermission menuPermission = new MenuPermission(
                new Permission(request.getPermissionId()),
                new Menu(request.getMenuId())
        );
        this.menuPermissionRepository.save(menuPermission);
    }

    @Override
    public void assignMenuPermissionForUser(UserMenuPermissionRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        UserMenuPermission userMenuPermission = new UserMenuPermission(
                new User(request.getUserId()),
                new MenuPermission(request.getMenuPermissionId())
        );
        this.userMenuPermissionRepository.save(userMenuPermission);
    }

    @Override
    public void revokeMenuPermissionFromUser(UserMenuPermissionRequest request) {
        this.userMenuPermissionRepository.deleteByUserIdAndMenuPermissionId(
                request.getUserId(),
                request.getMenuPermissionId()
        );
    }

    @Override
    public void revokedMenuFromPermission(MenuPermissionRequest request) {
        this.menuPermissionRepository.deleteByPermissionIdAndMenuId(
                request.getPermissionId(),
                request.getPermissionId()
        );
    }

    @Override
    public void revokedAllMenuFromPermission(Long permissionId) {
        this.menuPermissionRepository.deleteAllByPermissionId(permissionId);
    }

    @Override
    @Transactional
    public void deleteMenu(Long menuId) {
        this.menuPermissionRepository.deleteAllByMenuId(menuId);
        this.menuRepository.deleteById(menuId);
    }

    @Override
    public List<Menu> getAllMenu() {
        return this.menuRepository.findAll();
    }

    @Override
    public Menu getByName(String name) {
        return this.menuRepository.findByName(name);
    }

    @Override
    public Menu getById(Long id) {
        return this.menuRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("not found id"));
    }

    @Override
    public List<Menu> getAllByPermissionId(Long permissionId) {
        return ListUtils.convert(menuPermissionRepository.findAllByPermissionId(permissionId), m -> m.getMenu());
    }
}
