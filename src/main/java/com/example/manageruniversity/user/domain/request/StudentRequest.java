package com.example.manageruniversity.user.domain.request;

import com.example.manageruniversity.user.domain.enums.Role;
import lombok.Data;

@Data
public class StudentRequest extends PersonRequest{
    private String courseId;
    private String majorId;
}
