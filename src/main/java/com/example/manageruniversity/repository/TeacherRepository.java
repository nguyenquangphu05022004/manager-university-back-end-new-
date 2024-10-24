package com.example.manageruniversity.repository;

import com.example.manageruniversity.user.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByUserUsername(String username);
}
