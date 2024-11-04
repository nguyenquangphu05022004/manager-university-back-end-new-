package com.example.manageruniversity.core.user.domain.dto;

import com.example.manageruniversity.core.user.domain.entity.Teacher;
import lombok.Getter;

@Getter
public class TeacherDto extends PersonDto {
    public TeacherDto(Teacher teacher) {
        super(teacher);
    }
}
