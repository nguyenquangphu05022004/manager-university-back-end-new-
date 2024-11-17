package com.example.manageruniversity.university.member.domain.dto.request;

import lombok.Data;

@Data
public class StudentRequest extends PersonRequest{
    private String courseId;
    private String majorId;
}
