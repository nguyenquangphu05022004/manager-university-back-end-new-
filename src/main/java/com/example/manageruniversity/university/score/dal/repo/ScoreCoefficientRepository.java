package com.example.manageruniversity.university.score.dal.repo;

import com.example.manageruniversity.university.score.dal.entity.ScoreCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreCoefficientRepository extends JpaRepository<ScoreCoefficient, Long> {
    List<ScoreCoefficient> findAllBySchoolYearIdAndSubjectSubjectId(Long schoolYearId, String subjectId);
}
