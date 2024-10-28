package com.example.manageruniversity.exam;

import com.example.manageruniversity.core.subject.SubjectDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TestDto {
    private Long id;
    private int numberOfStudent;
    private LocalDate startDate;
    private LocalTime startTime;
    private int inMinutes;
    private String format;
    private String room;
    private SubjectDto subject;
}
