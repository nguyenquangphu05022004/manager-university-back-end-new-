package com.example.manageruniversity.core.permission.domain.role;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "sys_roles")
@Getter
public class Role extends SubBaseEntity {
    private String name;

}
