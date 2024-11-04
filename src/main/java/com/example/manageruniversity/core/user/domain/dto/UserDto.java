package com.example.manageruniversity.core.user.domain.dto;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.user.domain.enums.Role;
import com.example.manageruniversity.core.user.domain.entity.User;
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
        this.entityId = user.getPerson().getPersonId();
    }
}
