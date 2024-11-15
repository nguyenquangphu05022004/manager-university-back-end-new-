package com.example.manageruniversity.core.tuition.service.tuition;

import com.example.manageruniversity.core.tuition.dal.dataobject.Tuition;

import java.util.List;

public interface TuitionService {
    List<Tuition> getAllByStudentId(Long studentId);
    void createForAllStudentBySchoolYearIdAndCourseId(Long schoolYearId, String courseId);
}
