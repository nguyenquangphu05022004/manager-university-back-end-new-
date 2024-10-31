package com.example.manageruniversity.core.course.domain.dto;

import lombok.Getter;

@Getter
public class CourseDto {
    private String courseCode;
    private String name;
    public CourseDto(com.example.manageruniversity.core.course.domain.entity.Course course) {
        if(course != null) {
            this.courseCode = course.getCourseId();
            this.name = course.getName();
        }
    }

}
