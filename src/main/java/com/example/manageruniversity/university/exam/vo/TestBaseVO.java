package com.example.manageruniversity.university.exam.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TestBaseVO {
    @Schema(description = "so luong sinh vien trong phong thi", example = "24")
    private int numberOfStudent;
    @Schema(description = "Ngay bat dau", example = "12-11-2024")
    private LocalDate startDate;
    @Schema(description = "thoi gian bat dau", example = "13:00:00")
    private LocalTime startTime;
    @Schema(description = "so phut cua mot bai thi", example = "90")
    private int inMinutes;
    @Schema(description = "Hinh thuc thi", example = "Trac nghiem")
    private String format;
}
