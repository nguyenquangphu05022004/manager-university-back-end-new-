package com.example.manageruniversity.core.course.service;

import com.example.manageruniversity.core.course.domain.entity.Course;
import com.example.manageruniversity.core.course.domain.request.CourseRequest;

import java.util.List;

public interface CourseService {
    Course update(CourseRequest courseRequest);
    List<Course> getAll();
    Course getById(String courseId);

}
