package com.example.manageruniversity.user.domain.request;

import com.example.manageruniversity.user.enums.Role;
import lombok.Data;

@Data
public class TeacherRequest extends UserRequest{
    private Role role = Role.TEACHER;
}
