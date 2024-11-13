package com.example.manageruniversity.core.member.domain.dto.response;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.major.MajorDto;
import com.example.manageruniversity.core.member.dal.entities.Student;
import lombok.Getter;

@Getter
public class StudentDto {
    private Course course;
    private MajorDto major;


    public StudentDto(Student student) {

        this.course = ObjectUtils.init(Course.class, student.getCourse());
        this.major = ObjectUtils.init(MajorDto.class, student.getMajor());
    }
}
