package com.example.manageruniversity.score.domain.request;

import lombok.Data;

@Data
public class ScoreCoefficientRequest {
    private Double coefficient;
    private int scoreTypeIndex;
    private String subjectId;
}
