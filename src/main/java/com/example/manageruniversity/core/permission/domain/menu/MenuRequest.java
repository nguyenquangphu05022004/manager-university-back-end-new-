package com.example.manageruniversity.core.permission.domain.menu;

import lombok.Data;

@Data
public class MenuRequest {
    private String name;
    private Menu.Action action;
}
