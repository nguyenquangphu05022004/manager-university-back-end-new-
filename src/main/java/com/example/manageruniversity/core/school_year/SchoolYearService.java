package com.example.manageruniversity.core.school_year;

import org.springframework.data.domain.Page;

public interface SchoolYearService {
    SchoolYear update(SchoolYearRequest request);
    Page<SchoolYear> getAllByCourseId(String courseId, int page);
    SchoolYear getById(Long schoolYearId);
}
