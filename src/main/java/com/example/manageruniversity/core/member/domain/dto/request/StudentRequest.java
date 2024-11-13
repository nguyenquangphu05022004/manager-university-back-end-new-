package com.example.manageruniversity.core.member.domain.dto.request;

import lombok.Data;

@Data
public class StudentRequest extends PersonRequest{
    private String courseId;
    private String majorId;
}
