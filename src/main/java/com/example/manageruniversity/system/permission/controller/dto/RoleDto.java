package com.example.manageruniversity.system.permission.controller.dto;

import com.example.manageruniversity.system.permission.domain.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private String name;
    private Role.RoleType roleType;

    public RoleDto(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.roleType = role.getRoleType();
    }
}
