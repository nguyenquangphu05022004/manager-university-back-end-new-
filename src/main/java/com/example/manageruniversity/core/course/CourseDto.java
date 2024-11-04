package com.example.manageruniversity.core.course;

import lombok.Getter;

@Getter
public class CourseDto {
    private String courseCode;
    private String name;
    public CourseDto(Course course) {
        if(course != null) {
            this.courseCode = course.getCourseId();
            this.name = course.getName();
        }
    }

}
