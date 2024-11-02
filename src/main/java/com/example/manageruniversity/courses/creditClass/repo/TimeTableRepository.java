package com.example.manageruniversity.courses.creditClass.repo;

import com.example.manageruniversity.courses.creditClass.domain.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
}
