package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.SchoolYear;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long> {
    @Query("select s from SchoolYear s order by s.id desc")
    List<SchoolYear> findAllOrderByIdDESC();
}
