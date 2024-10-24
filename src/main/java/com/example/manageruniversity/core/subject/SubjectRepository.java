package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.core.major.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
