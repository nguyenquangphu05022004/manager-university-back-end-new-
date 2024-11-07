package com.example.manageruniversity.core.permission.domain.menu;

import lombok.Data;

@Data
public class UserMenuPermissionRequest {
    private Long userId;
    private Long menuPermissionId;
}
