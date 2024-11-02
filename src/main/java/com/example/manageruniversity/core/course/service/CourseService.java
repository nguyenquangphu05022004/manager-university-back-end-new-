package com.example.manageruniversity.core.course.service;

import com.example.manageruniversity.core.course.domain.entity.Course;
import com.example.manageruniversity.core.course.domain.request.CourseRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    Course update(CourseRequest courseRequest);
    Page<Course> getAll(int page);
    Course getById(String courseId);

}
