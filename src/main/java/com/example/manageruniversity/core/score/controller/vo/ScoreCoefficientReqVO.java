package com.example.manageruniversity.core.score.controller.vo;

import com.example.manageruniversity.core.score.dal.enums.ScoreType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(name = "Score Coefficient Request - Thong tin tao trong so diem thanh phan cua mon hoc")
public class ScoreCoefficientReqVO {
    @Schema(description = "Trong so cua mon hoc", example = "0.7")
   @NotNull(message = "Trong so mon khong the null")
    private Double coefficient;

    @Schema(description = "Loai trong so", example = "MIDTERM")
    @NotNull(message = "Loai trong so khong the null")
    private ScoreType scoreType;

    @NotNull(message = "mon hoc khong the null")
    @Schema(description = "Mon hoc", example = "BAS1000")
    private String subjectId;

    @NotNull(message = "nam hoc khong the null")
    @Schema(description = "nam hoc/hoc ky: 2022-2023 hoc ky 3", example = "1")
    private Long schoolYearId;
}
