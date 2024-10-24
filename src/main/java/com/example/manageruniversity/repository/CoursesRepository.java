package com.example.manageruniversity.repository;

import com.example.manageruniversity.core.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
