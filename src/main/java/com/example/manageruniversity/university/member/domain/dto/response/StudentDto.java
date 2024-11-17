package com.example.manageruniversity.university.member.domain.dto.response;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.university.course.Course;
import com.example.manageruniversity.university.major.MajorDto;
import com.example.manageruniversity.university.member.dal.entities.Student;
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
