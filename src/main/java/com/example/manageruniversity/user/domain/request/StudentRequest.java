package com.example.manageruniversity.user.domain.request;

import com.example.manageruniversity.user.enums.Role;
import lombok.Data;

@Data
public class StudentRequest extends UserRequest{
    private Role role = Role.STUDENT;
    private String courseId;
    private String majorId;
}
