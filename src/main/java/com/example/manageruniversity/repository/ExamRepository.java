package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    Optional<Exam> findBySeasonIdAndSubjectIdAndRoomClassId(Long seasonId, Long subjectId, Long roomClassId);
}
