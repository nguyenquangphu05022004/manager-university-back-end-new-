package com.example.manageruniversity.university.member.dal.repo;

import com.example.manageruniversity.university.member.dal.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByMajorMajorIdAndCourseCourseId(String majorId, String courseId);
}
