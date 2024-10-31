package com.example.manageruniversity.core.schoolYear.repo;

import com.example.manageruniversity.core.schoolYear.domain.entity.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long> {
}
