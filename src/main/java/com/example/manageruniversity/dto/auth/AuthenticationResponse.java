package com.example.manageruniversity.dto.auth;

import com.example.manageruniversity.dto.AvatarResponse;
import com.example.manageruniversity.user.Role;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
    private Role role;
    private Object person;
    private AvatarResponse avatarResponse;
    private Date expired;

}
