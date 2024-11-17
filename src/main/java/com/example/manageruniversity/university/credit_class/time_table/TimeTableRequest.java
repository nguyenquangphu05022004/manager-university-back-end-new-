package com.example.manageruniversity.university.credit_class.time_table;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TimeTableRequest {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer dayOfWeek;
    private TimeTable.TimeType timeType;
    private Long creditClassId;
    private Long roomId;
}
