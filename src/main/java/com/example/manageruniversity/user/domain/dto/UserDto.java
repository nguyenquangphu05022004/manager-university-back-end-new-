package com.example.manageruniversity.user.domain.dto;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.user.domain.entity.User;
import com.example.manageruniversity.user.enums.Role;
import lombok.Getter;

@Getter
public class UserDto {
    private String username;
    private Role role;
    private String entityId;

    public UserDto(User user) {
        if(ObjectUtils.isNull(user)) return;
        this.username =user.getUsername();
        this.role = user.getRole();
        this.entityId = user.getEntityId();
    }
}
