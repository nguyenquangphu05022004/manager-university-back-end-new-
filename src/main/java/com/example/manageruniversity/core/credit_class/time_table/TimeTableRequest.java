package com.example.manageruniversity.core.credit_class.time_table;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeTableRequest {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Integer dayOfWeek;
    private TimeTable.TimeType timeType;
    private Long creditClassId;
    private Long roomId;
}
