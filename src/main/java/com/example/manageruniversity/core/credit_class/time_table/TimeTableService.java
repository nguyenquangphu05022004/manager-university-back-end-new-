package com.example.manageruniversity.core.credit_class.time_table;

public interface TimeTableService {
    TimeTable createOrUpdate(TimeTableRequest request);
    TimeTable getById(Long id);
    void delete(Long timeTableId);
    void deleteByCreditClass(Long creditClassId);
}
