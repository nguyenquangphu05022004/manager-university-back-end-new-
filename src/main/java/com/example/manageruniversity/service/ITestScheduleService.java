package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.TestScheduleRequest;
import com.example.manageruniversity.dto.TestScheduleResponse;

import java.util.List;

public interface ITestScheduleService {
    void saveOrUpdate(TestScheduleRequest testScheduleRequest);
    List<TestScheduleResponse> getListBySeasonIdAndStudentId(Long seasonId, Long studentId);
}
