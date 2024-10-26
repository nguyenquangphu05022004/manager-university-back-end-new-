package com.example.manageruniversity.exam;

public interface TestService {
    void createTest(TestRequest testRequest); //## create test by name student
    void update(Long testId, TestRequest testRequest);
    void getAllBySchoolYearIdAndStudentId(Long schoolYearId, String studentId);
}
