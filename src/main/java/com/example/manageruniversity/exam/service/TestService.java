package com.example.manageruniversity.exam.service;

import com.example.manageruniversity.exam.domain.entity.Test;
import com.example.manageruniversity.exam.domain.request.EditRequestStudent;
import com.example.manageruniversity.exam.domain.request.TestRequest;

import java.util.List;

public interface TestService {
    Test update(TestRequest testRequest);
    List<Test> getAllBySchoolYearIdAndStudentId(Long schoolYearId, String studentId);
    void addStudentIntoTest(EditRequestStudent request);
    void removeStudentFromTest(EditRequestStudent request);
}
