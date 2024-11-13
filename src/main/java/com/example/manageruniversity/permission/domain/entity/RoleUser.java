package com.example.manageruniversity.permission.domain.entity;

import com.example.manageruniversity.core.member.dal.entities.User;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sys_user_roles")
@Getter
@NoArgsConstructor
public class RoleUser extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public RoleUser(Long userId, Long roleId) {
        this.user = new User(userId);
        this.role = new Role(roleId);
    }
}
