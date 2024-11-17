package com.example.manageruniversity.university.credit_class.time_table;

public interface TimeTableService {
    TimeTable createOrUpdate(TimeTableRequest request);
    TimeTable getById(Long id);
    void delete(Long timeTableId);
    void deleteByCreditClass(Long creditClassId);
}
