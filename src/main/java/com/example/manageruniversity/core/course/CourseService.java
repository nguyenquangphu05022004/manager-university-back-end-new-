package com.example.manageruniversity.core.course;

import org.springframework.data.domain.Page;

public interface CourseService {
    Course update(CourseRequest courseRequest);
    Page<Course> getAll(int page);
    Course getById(String courseId);

}
