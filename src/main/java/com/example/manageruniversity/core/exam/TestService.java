package com.example.manageruniversity.core.exam;

import org.springframework.data.domain.Page;

import java.util.List;

public interface TestService {
    Test update(TestRequest testRequest);
    Page<Test> getAllBySchoolYearIdAndStudentId(Long schoolYearId, String studentId, int page);
    void addStudentIntoTest(EditRequestStudent request);
    void removeStudentFromTest(EditRequestStudent request);
}
