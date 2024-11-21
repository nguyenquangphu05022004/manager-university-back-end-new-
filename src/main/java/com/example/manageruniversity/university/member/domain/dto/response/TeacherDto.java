package com.example.manageruniversity.university.member.domain.dto.response;

import com.example.manageruniversity.university.member.dal.entities.Teacher;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDto  {

    public TeacherDto(Teacher teacher) {
        if(teacher == null) return;
    }
}
