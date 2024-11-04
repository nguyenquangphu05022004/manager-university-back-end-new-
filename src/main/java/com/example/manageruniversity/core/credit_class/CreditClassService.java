package com.example.manageruniversity.core.credit_class;

public interface CreditClassService {
    void createOrUpdate(CreditClass creditClass);
    void delete(Long creditClassId);
    void selectAllBySchoolYearId(Long schoolYearId);
    void selectAllForStudentRegister(String studentId);
}
