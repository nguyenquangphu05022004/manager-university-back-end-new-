package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.AspirationOfStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AspirationOfStudentRepository extends JpaRepository<AspirationOfStudent, Long> {
    List<AspirationOfStudent> findAllByStudentIdAndSeasonId(Long studentId, Long seasonId);
}
