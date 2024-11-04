package com.example.manageruniversity.tuition.service;

import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.tuition.dal.model.dto.TuitionDto;

import java.util.List;
import java.util.Map;

public interface TuitionService {
    Map<SchoolYearDto, List<TuitionDto>> getAllByStudentId(String studentId);
    void createForAllStudentBySchoolYearId(Long schoolYear);
}
