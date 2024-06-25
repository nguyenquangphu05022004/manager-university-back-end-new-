package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.AspirationOfStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AspirationOfStudentRepository extends JpaRepository<AspirationOfStudent, Long> {
    List<AspirationOfStudent> findAllByStudentIdAndAspirationRegisterId(
            Long studentId,
            Long aspirationId
    );
    Optional<AspirationOfStudent> findByStudentIdAndAspirationRegisterIdAndSubjectId(
            Long studentId,
            Long aspirationId,
            Long subjectId
    );
    List<AspirationOfStudent> findAllByAspirationRegisterIdAndSubjectId(
            Long aspirationRegisterId,
            Long subjectId
    );
}
