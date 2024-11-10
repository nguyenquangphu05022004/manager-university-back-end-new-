package com.example.manageruniversity.permission.service;

import com.example.manageruniversity.permission.controller.dto.RoleDto;
import com.example.manageruniversity.permission.domain.entity.Role;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    Role create(RoleDto roleDto);
    Role update(RoleDto roleDto);
    void delete(Long id);
    Role getById(Long id);
    List<Long> getListEnableRoleFromCacheByUserId(Long userId);
    List<Role> getList();
    boolean hasAnySuperRole(Collection<Long> ids);
}
