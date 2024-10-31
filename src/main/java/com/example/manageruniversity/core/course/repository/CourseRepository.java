package com.example.manageruniversity.core.course.repository;

import com.example.manageruniversity.core.course.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
