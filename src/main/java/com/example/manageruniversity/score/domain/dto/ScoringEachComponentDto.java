package com.example.manageruniversity.score.domain.dto;

import com.example.manageruniversity.score.domain.entity.ScoringEachComponent;
import lombok.Getter;

@Getter
public class ScoringEachComponentDto {
    private Long id;
    private Double value;
    private Long scoreId;
    private ScoreCoefficientDto scoreCoefficient;

    public ScoringEachComponentDto(ScoringEachComponent scoringEachComponent) {
        if(scoringEachComponent == null) return;
        this.id = scoringEachComponent.getId();
        this.value = scoringEachComponent.getValue();
        this.scoreId = scoringEachComponent.getScore().getId();
        this.scoreCoefficient = new ScoreCoefficientDto(scoringEachComponent.getScoreCoefficient());
    }
}
