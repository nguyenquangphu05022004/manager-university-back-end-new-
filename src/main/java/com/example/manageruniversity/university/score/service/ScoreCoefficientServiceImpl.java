package com.example.manageruniversity.university.score.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.university.score.controller.vo.ScoreCoefficientReqVO;
import com.example.manageruniversity.university.score.dal.entity.ScoreCoefficient;
import com.example.manageruniversity.university.score.dal.repo.ScoreCoefficientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreCoefficientServiceImpl implements ScoreCoefficientService{

    private final ScoreCoefficientRepository scoreCoefficientRepository;
    @Override
    @Transactional
    public void create(ScoreCoefficientReqVO request) {
        ScoreCoefficient scoreCoefficient = new ScoreCoefficient(
                request.getCoefficient(),
                request.getScoreType(),
                request.getSubjectId(),
                request.getSchoolYearId()
        );
        this.scoreCoefficientRepository.save(scoreCoefficient);
    }

    @Override
    public void update(Long scoreCoefficientId, ScoreCoefficientReqVO request) {
        ScoreCoefficient scoreCoefficient = this.scoreCoefficientRepository.findById(scoreCoefficientId)
                .orElseThrow(() -> new ResourcesNotFoundException("not found"));
        scoreCoefficient.setCoefficient(request.getCoefficient());
        scoreCoefficient.setScoreType(request.getScoreType());
        scoreCoefficient.getSubject().setSubjectId(request.getSubjectId());
        scoreCoefficient.getSchoolYear().setId(request.getSchoolYearId());
        this.scoreCoefficientRepository.save(scoreCoefficient);
    }

    @Override
    public List<ScoreCoefficient> getList() {
        return scoreCoefficientRepository.findAll();
    }

    @Override
    public List<ScoreCoefficient> getListBySchoolYearIdAndSubjectId(Long schoolYearId, String subjectId) {
        return this.scoreCoefficientRepository.findAllBySchoolYearIdAndSubjectSubjectId(schoolYearId, subjectId);
    }
}
