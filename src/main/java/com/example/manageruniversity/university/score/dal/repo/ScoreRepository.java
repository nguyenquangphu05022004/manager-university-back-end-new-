package com.example.manageruniversity.university.score.dal.repo;

import com.example.manageruniversity.university.score.dal.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAllBySchoolYearId(Long schoolYearId);

    List<Score> findAllByStudentId(Long studentId);
}
