package com.example.manageruniversity.university.tuition.service.tuition;

import com.example.manageruniversity.university.tuition.dal.dataobject.Tuition;

import java.util.List;

public interface TuitionService {
    List<Tuition> getAllByStudentId(Long studentId);
    void createForAllStudentBySchoolYearIdAndCourseId(Long schoolYearId, String courseId);
}
