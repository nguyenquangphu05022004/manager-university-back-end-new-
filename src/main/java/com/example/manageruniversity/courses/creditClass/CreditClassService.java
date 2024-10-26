package com.example.manageruniversity.courses.creditClass;

public interface CreditClassService {
    void create();
    void update();
    void delete();
    void selectAllBySchoolYearId(Long schoolYearId);
    void selectAllForStudentRegister(String studentId);
}
