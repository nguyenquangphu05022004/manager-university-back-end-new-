package com.example.manageruniversity.core.permission.domain.menu;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bind_menu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Menu extends SubBaseEntity {
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private Action action;


    public Menu(Long id) {
        setId(id);
    }
    public static enum Action {
        CREATE, UPDATE, DELETE
    }
}
