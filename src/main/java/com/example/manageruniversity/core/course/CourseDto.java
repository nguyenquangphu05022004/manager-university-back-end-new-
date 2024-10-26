package com.example.manageruniversity.core.course;

import lombok.Getter;

@Getter
public class CourseDto {
    private String courseId;
    private String name;
    public CourseDto(Course course) {
        this.courseId = course.getCourseId();
        this.name = course.getName();
    }
}
