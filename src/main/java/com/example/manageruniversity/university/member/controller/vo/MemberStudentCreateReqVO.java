package com.example.manageruniversity.university.member.controller.vo;

import lombok.Data;

@Data
public class MemberStudentCreateReqVO extends MemberCreateReqVO{
    private String majorId;
    private String courseId;
}
