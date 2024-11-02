package com.example.manageruniversity.courses.creditClass.domain.request;

import com.example.manageruniversity.courses.creditClass.domain.entity.TimeTable;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeTableRequest {
    private LocalDateTime start;
    private LocalDateTime end;
    private Short dayOfWeek;
    private TimeTable.TimeType timeType;
    private Long creditClassId;
    private Long roomId;
}
