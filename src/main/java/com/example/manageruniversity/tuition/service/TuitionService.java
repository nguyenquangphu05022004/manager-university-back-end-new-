package com.example.manageruniversity.tuition.service;

import com.example.manageruniversity.core.schoolYear.SchoolYearDto;
import com.example.manageruniversity.user.StudentDto;

import java.util.List;
import java.util.Map;

public interface TuitionService {
    Map<SchoolYearDto, List<StudentDto>> getAllByStudentId(String studentId);
    void createForAllStudentBySchoolYearId(Long schoolYear);
}
