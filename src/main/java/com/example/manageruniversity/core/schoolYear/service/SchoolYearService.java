package com.example.manageruniversity.core.schoolYear.service;

import com.example.manageruniversity.core.schoolYear.domain.entity.SchoolYear;
import com.example.manageruniversity.core.schoolYear.domain.request.SchoolYearRequest;

import java.util.List;

public interface SchoolYearService {
    SchoolYear update(SchoolYearRequest request);
    List<SchoolYear> getAllByCourseId(String courseId);
    SchoolYear getById(Long schoolYearId);
}
