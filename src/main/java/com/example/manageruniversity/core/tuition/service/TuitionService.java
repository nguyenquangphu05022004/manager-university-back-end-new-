package com.example.manageruniversity.core.tuition.service;

import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.core.tuition.controller.vo.TuitionBaseResVO;

import java.util.List;
import java.util.Map;

public interface TuitionService {
    Map<SchoolYearDto, List<TuitionBaseResVO>> getAllByStudentId(String studentId);
    void createForAllStudentBySchoolYearId(Long schoolYear);
}
