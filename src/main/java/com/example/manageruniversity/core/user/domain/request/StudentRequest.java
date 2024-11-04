package com.example.manageruniversity.core.user.domain.request;

import lombok.Data;

@Data
public class StudentRequest extends PersonRequest{
    private String courseId;
    private String majorId;
}
