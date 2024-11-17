package com.example.manageruniversity.university.score.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.university.score.controller.vo.ScoringEachComponentReqVO;
import com.example.manageruniversity.university.score.dal.entity.ScoringEachComponent;
import com.example.manageruniversity.university.score.dal.repo.ScoringEachComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoringEachComponentServiceImpl implements ScoringEachComponentService{

    private final ScoringEachComponentRepository scoringEachComponentRepository;

    @Override
    public ScoringEachComponent create(ScoringEachComponentReqVO request) {
        ScoringEachComponent scoringEachComponent = new ScoringEachComponent(
                request.getValue(),
                request.getScoreId(),
                request.getScoreCoefficientId()
        );
        return this.scoringEachComponentRepository.save(scoringEachComponent);
    }

    @Override
    public ScoringEachComponent update(Long scoringEachComponentId, ScoringEachComponentReqVO request) {
        ScoringEachComponent scoringEachComponent = this.scoringEachComponentRepository.findById(scoringEachComponentId)
                .orElseThrow(() -> new ResourcesNotFoundException("not found"));
        scoringEachComponent.setValue(request.getValue());
        this.scoringEachComponentRepository.save(scoringEachComponent);
        return scoringEachComponent;
    }
}
