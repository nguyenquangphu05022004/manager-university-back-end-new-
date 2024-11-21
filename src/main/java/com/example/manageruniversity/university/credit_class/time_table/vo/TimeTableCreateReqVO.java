package com.example.manageruniversity.university.credit_class.time_table.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TimeTableCreateReqVO extends TimeTableBaseVO{
    @NotNull
    private Long creditClassId;
    private Long roomId;
}
