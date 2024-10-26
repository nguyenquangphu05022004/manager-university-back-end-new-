package com.example.manageruniversity.exam;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class TestRequest {
    private Long schoolYearId;
    private String subjectId;
    private int numberOfStudent;
    private LocalDate startDate;
    private LocalTime startTime;
    private int inMinutes;
    private String format;
}
