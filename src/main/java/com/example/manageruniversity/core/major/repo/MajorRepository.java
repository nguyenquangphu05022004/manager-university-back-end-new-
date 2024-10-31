package com.example.manageruniversity.core.major.repo;

import com.example.manageruniversity.core.major.domain.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, String> {
}
