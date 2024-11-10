package com.example.manageruniversity.permission.domain.entity;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "permission_menu_role")
@Entity
@NoArgsConstructor
@Getter
public class MenuRole extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public MenuRole(Long roleId, Long menuId) {
        this.role = new Role(roleId);
        this.menu = new Menu(menuId);
    }

}
