package com.example.manageruniversity.core.permission.domain.menu;

import com.example.manageruniversity.core.permission.domain.permission.Permission;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "sys_permission_menu")
@Getter
public class MenuPermission extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
