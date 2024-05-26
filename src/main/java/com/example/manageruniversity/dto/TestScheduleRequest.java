package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.TestType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TestScheduleRequest  {
    private Integer testGroup;
    private Integer numberOfStudent;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private ExamRequest examRequest;
}
