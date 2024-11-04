package com.example.manageruniversity.core.credit_class.time_table;

public interface TimeTableService {
    TimeTable createOrUpdate();
    void delete(Long timeTableId);
}
