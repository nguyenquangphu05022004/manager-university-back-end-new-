package com.example.manageruniversity.system.permission.domain.entity;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bind_menu")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class Menu extends SubBaseEntity {
    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String permission;


    public Menu(Long menuId) {
        setId(menuId);
    }
}
