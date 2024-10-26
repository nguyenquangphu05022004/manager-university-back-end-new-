package com.example.manageruniversity.core.course;

public interface CourseService {
    CourseDto create(CourseRequest courseRequest);
    CourseDto update(Long courseId, CourseRequest courseRequest);
    void selectAll();
    CourseDto selectById(Long courseId);

}
