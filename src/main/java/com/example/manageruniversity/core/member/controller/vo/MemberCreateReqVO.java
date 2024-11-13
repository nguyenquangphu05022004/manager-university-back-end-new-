package com.example.manageruniversity.core.member.controller.vo;

import com.example.manageruniversity.core.member.domain.enums.MemberType;
import lombok.Data;

import java.util.Date;

@Data
public class MemberCreateReqVO {
    private String username;
    private String password;
    private MemberType memberType;
    private String email;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private Boolean sex;
}
