package com.example.manageruniversity.user.domain.dto;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.course.domain.dto.Course;
import com.example.manageruniversity.core.major.domain.dto.MajorDto;
import com.example.manageruniversity.user.domain.entity.Student;
import lombok.Getter;

@Getter
public class StudentDto extends PersonDto{
    private Course course;
    private MajorDto major;


    public StudentDto(Student student) {
        super(student);
        this.course = ObjectUtils.init(Course.class, student.getCourse());
        this.major = ObjectUtils.init(MajorDto.class, student.getMajor());
    }
}
