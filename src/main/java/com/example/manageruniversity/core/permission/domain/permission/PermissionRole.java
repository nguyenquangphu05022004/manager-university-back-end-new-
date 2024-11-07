package com.example.manageruniversity.core.permission.domain.permission;

import com.example.manageruniversity.core.permission.domain.role.Role;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sys_permission_role")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRole extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
