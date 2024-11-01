package com.example.manageruniversity.exam.repo;

import com.example.manageruniversity.exam.domain.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
