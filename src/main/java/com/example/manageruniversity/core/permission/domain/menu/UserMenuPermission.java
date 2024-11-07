package com.example.manageruniversity.core.permission.domain.menu;

import com.example.manageruniversity.core.user.domain.entity.User;
import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sys_user_menu_permission")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserMenuPermission extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "menu_permission_id")
    private MenuPermission menuPermission;

    public UserMenuPermission(Long id) {
        setId(id);
    }
}
