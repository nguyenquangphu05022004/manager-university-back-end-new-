package com.example.manageruniversity.university.school_year;

import java.util.List;

public interface SchoolYearService {
    SchoolYear update(SchoolYearRequest request);
    List<SchoolYear> getAllByCourseId(String courseId);
    SchoolYear getById(Long schoolYearId);

    List<SchoolYear> getAll();

}
