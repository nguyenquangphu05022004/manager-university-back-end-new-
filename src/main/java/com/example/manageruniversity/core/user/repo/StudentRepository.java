package com.example.manageruniversity.core.user.repo;

import com.example.manageruniversity.core.user.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
