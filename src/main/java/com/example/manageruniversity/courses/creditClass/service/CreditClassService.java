package com.example.manageruniversity.courses.creditClass.service;

import com.example.manageruniversity.courses.creditClass.domain.entity.CreditClass;

public interface CreditClassService {
    void createOrUpdate(CreditClass creditClass);
    void delete(Long creditClassId);
    void selectAllBySchoolYearId(Long schoolYearId);
    void selectAllForStudentRegister(String studentId);
}
