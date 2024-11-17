package com.example.manageruniversity.university.member.domain.dto.request;

import com.example.manageruniversity.university.member.domain.enums.MemberType;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private MemberType memberType;
    private String email;
}
