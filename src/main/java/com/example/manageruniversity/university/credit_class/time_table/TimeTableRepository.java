package com.example.manageruniversity.university.credit_class.time_table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

    @Modifying
    void deleteAllByCreditClassId(Long creditClassId);

    List<TimeTable> findAllByCreditClassId(Long creditClassId);
}
