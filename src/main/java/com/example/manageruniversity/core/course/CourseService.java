package com.example.manageruniversity.core.course;

import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    Course update(CourseRequest courseRequest);
    List<Course> getAll();
    Course getById(String courseId);

}
