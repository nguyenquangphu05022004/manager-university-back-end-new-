package com.example.manageruniversity.score.domain.request;

import lombok.Data;

@Data
public class ScoringEachComponentRequest {
    private Long scoreCoefficientId;
    private String subjectId;
    private Long scoreId;
}
