package com.example.manageruniversity.core.score.controller.vo;

import com.example.manageruniversity.core.score.dal.entity.ScoringEachComponent;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Scoring Each Component - Diem thanh phan cua mon hoc")
public class ScoringEachComponentResVO {

    @Schema(description = "Trong so cua mon hoc")
    private ScoreCoefficientResVO scoreCoefficient;
    @Schema(description= "Gia tri cua diem thanh phan", example = "8.9")
    private Double value;


    public ScoringEachComponentResVO(ScoringEachComponent scoringEachComponent) {
        this.scoreCoefficient = new ScoreCoefficientResVO(scoringEachComponent.getScoreCoefficient());
        this.value = scoringEachComponent.getValue();
    }
}
