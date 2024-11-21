package com.example.manageruniversity.university.credit_class.time_table;

import com.example.manageruniversity.university.credit_class.time_table.vo.TimeTableCreateReqVO;

import java.util.Collection;
import java.util.List;

public interface TimeTableService {
    TimeTable create(TimeTableCreateReqVO request);
    TimeTable getById(Long id);
    void delete(Long timeTableId);
    void deleteByCreditClass(Long creditClassId);

    List<TimeTable> getAllByCreditClassId(Long creditClassId);
}
