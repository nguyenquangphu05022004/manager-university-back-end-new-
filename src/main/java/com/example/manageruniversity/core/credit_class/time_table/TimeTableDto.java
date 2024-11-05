package com.example.manageruniversity.core.credit_class.time_table;

import com.example.manageruniversity.core.credit_class.CreditClass;
import com.example.manageruniversity.core.location.Room;
import com.example.manageruniversity.core.location.RoomDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeTableDto {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Integer dayOfWeek;
    private TimeTable.TimeType timeType;
    private RoomDto room;
    public TimeTableDto(TimeTable timeTable) {
        this.start = timeTable.getStart();
        this.end = timeTable.getEnd();
        this.id = timeTable.getId();
        this.dayOfWeek = timeTable.getDayOfWeek();
        this.timeType = timeTable.getTimeType();
        this.room = new RoomDto(timeTable.getRoom());
    }
}
