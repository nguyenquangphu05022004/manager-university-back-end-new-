package com.example.manageruniversity.core.score.controller.vo;

import lombok.Data;

@Data
public class ScoringEachComponentReqVO {
    private Long scoreCoefficientId;
    private Long scoreId;
    private Double value;
}
