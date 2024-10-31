package com.example.manageruniversity.core.subject.repo;

import com.example.manageruniversity.core.subject.domain.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
