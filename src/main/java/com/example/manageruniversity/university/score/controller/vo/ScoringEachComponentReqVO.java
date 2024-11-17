package com.example.manageruniversity.university.score.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Schema(name = "Scoring Each Component - Diem thanh phan")
@Data
public class ScoringEachComponentReqVO {
    @NotNull(message = "can't null")
    @Schema(description = "id cua trong so diem thanh phan")
    private Long scoreCoefficientId;

    @NotNull(message = "can't null")
    private Long scoreId;

    @Schema(description = "gia tri diem")
    @NotNull(message = "can't null")
    private Double value;
}
