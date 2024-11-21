package com.example.manageruniversity.university.credit_class.time_table.vo;

import com.example.manageruniversity.university.credit_class.time_table.TimeTable;
import com.example.manageruniversity.university.location.Room;
import com.example.manageruniversity.university.location.RoomDto;
import lombok.Data;

@Data
public class TimeTableResVO extends TimeTableBaseVO{
    private Long id;
    private RoomDto room;

    public TimeTableResVO(TimeTable timeTable) {
        super(timeTable);
        if(timeTable == null) return;
        this.id = timeTable.getId();
        this.room = new RoomDto(timeTable.getRoom());
    }
}
