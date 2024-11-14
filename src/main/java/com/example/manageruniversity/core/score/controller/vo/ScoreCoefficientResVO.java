package com.example.manageruniversity.core.score.controller.vo;

import com.example.manageruniversity.core.score.dal.entity.ScoreCoefficient;
import com.example.manageruniversity.core.score.dal.enums.ScoreType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Score Coefficient - Trong so diem cua mon hoc")
public class ScoreCoefficientResVO {

    @Schema(description = "id trong so diem thanh phan", example = "1")
    private Long id;

    @Schema(description = "Trong so thanh phan cua mon hoc", example = "0.7")
    private Double coefficient;

    @Schema( description = "Loai trong so thanh phan", example = "PRACTICE")
    private String scoreType;


    public ScoreCoefficientResVO(ScoreCoefficient scoreCoefficient) {
        this.id =  scoreCoefficient.getId();
        this.coefficient = scoreCoefficient.getCoefficient();
        this.scoreType = scoreCoefficient.getScoreType().getValue();
    }
}
