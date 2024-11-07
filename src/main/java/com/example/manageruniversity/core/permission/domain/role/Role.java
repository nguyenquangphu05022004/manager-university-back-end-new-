package com.example.manageruniversity.core.permission.domain.role;

import com.example.manageruniversity.share.SubBaseEntity;
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
public class Role extends SubBaseEntity {
    @Setter
    private String name;
    public Role(Long id){
        setId(id);
    }
}
