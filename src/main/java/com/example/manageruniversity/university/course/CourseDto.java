package com.example.manageruniversity.university.course;

import com.example.manageruniversity.common.excel.annotation.ExcelProperties;
import lombok.Getter;

@Getter
public class CourseDto {
    @ExcelProperties(column = "Ma khoa hoc")
    private String courseCode;
    @ExcelProperties(column = "Ten khoa hoc")
    private String name;
    public CourseDto(Course course) {
        if(course != null) {
            this.courseCode = course.getCourseId();
            this.name = course.getName();
        }
    }

}
