package com.example.manageruniversity.user.domain.request;

import com.example.manageruniversity.user.domain.enums.Role;
import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {
    private String username;
    private String password;
    private Role role;
    private String email;
}
