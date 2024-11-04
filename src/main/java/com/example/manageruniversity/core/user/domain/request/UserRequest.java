package com.example.manageruniversity.core.user.domain.request;

import com.example.manageruniversity.core.user.domain.enums.Role;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private Role role;
    private String email;
}
