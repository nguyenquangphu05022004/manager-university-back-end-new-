package com.example.manageruniversity.university.course;

import java.util.List;

public interface CourseService {
    Course update(CourseRequest courseRequest);
    List<Course> getAll();
    Course getById(String courseId);

}
