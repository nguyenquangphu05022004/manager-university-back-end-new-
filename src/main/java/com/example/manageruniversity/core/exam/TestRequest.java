package com.example.manageruniversity.core.exam;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class TestRequest {
    private Long testId;
    private Long schoolYearId;
    private String subjectId;
    private int numberOfStudent;
    private LocalDate startDate;
    private LocalTime startTime;
    private int inMinutes;
    private String format;
}
