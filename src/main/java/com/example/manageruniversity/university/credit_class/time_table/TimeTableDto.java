package com.example.manageruniversity.university.credit_class.time_table;

import com.example.manageruniversity.university.location.RoomDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TimeTableDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer dayOfWeek;
    private TimeTable.TimeType timeType;
    private RoomDto room;
    public TimeTableDto(TimeTable timeTable) {
        this.startDate = timeTable.getStartDate();
        this.endDate = timeTable.getEndDate();
        this.startTime = timeTable.getStartTime();
        this.endTime = timeTable.getEndTime();
        this.id = timeTable.getId();
        this.dayOfWeek = timeTable.getDayOfWeek();
        this.timeType = timeTable.getTimeType();
        this.room = new RoomDto(timeTable.getRoom());
    }
}
