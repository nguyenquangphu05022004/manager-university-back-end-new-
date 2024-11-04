package com.example.manageruniversity.core.score.domain.request;

import lombok.Data;

@Data
public class ScoreCoefficientRequest {
    private Double coefficient;
    private int scoreTypeIndex;
    private String subjectId;
}
