package com.example.manageruniversity.university.credit_class.time_table.vo;

import lombok.Data;

@Data
public class TimeTableUpdateReqVO extends TimeTableBaseVO{
    private Long creditClassId;
    private Long roomId;
    private Long id;
}
