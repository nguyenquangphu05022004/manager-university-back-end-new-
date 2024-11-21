package com.example.manageruniversity.university.credit_class.time_table.vo;

import com.example.manageruniversity.university.credit_class.time_table.TimeTable;
import com.example.manageruniversity.university.location.RoomDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TimeTableBaseVO {
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
    @NotNull
    private Integer dayOfWeek;
    @NotNull
    private TimeTable.TimeType timeType;

    public TimeTableBaseVO() {

    }
    public TimeTableBaseVO(TimeTable timeTable) {
        if(timeTable == null) return;
        this.startDate = timeTable.getStartDate();
        this.endDate = timeTable.getEndDate();
        this.startTime = timeTable.getStartTime();
        this.endTime = timeTable.getEndTime();
        this.dayOfWeek = timeTable.getDayOfWeek();
        this.timeType = timeTable.getTimeType();
    }
}
