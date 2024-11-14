package com.example.manageruniversity.core.exam.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Test Request - Tao phong thi cho sinh vien")
public class TestReqVO extends TestBaseVO{
    @Schema(description = "bai thi cua hoc ki nao", example = "2023-2024 hoc ky 2")
    private Long schoolYearId;
    @Schema(description = "mon thi la gi", example = "Cau truc du lieu va giai thuat")
    private String subjectId;
}
