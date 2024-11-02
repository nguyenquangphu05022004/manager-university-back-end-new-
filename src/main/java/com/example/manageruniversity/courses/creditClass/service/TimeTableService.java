package com.example.manageruniversity.courses.creditClass.service;

import com.example.manageruniversity.courses.creditClass.domain.entity.TimeTable;

public interface TimeTableService {
    TimeTable createOrUpdate();
    void delete(Long timeTableId);
}
