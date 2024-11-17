package com.example.manageruniversity.web.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LoginUser {
    private Long userId;
    private String username;
    private LocalDateTime expires;
}
