package com.example.manageruniversity.system.permission.domain.entity;

import com.example.manageruniversity.common.base.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sys_roles")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Role extends SubBaseEntity {

    private String name;
    private RoleType roleType;


    public static enum RoleType {
        SUPER_ADMIN,
        ADMIN,
        USER
    }
    public Role(Long id){
        setId(id);
    }
}
