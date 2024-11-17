package com.example.manageruniversity.university.credit_class.time_table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

    @Modifying
    void deleteAllByCreditClassId(Long creditClassId);
}
