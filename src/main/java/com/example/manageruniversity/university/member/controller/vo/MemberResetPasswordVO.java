package com.example.manageruniversity.university.member.controller.vo;

import lombok.Data;

@Data
public class MemberResetPasswordVO {
    private String oldPass;
    private String newPass;
}
