package com.example.manageruniversity.user.domain.dto;

import com.example.manageruniversity.user.domain.entity.Teacher;
import lombok.Getter;

@Getter
public class TeacherDto extends PersonDto {
    public TeacherDto(Teacher teacher) {
        super(teacher);
    }
}
