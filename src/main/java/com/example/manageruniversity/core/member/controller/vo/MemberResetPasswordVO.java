package com.example.manageruniversity.core.member.controller.vo;

import lombok.Data;

@Data
public class MemberResetPasswordVO {
    private String oldPass;
    private String newPass;
}
