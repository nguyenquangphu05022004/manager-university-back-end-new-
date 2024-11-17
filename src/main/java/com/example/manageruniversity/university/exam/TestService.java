package com.example.manageruniversity.university.exam;

import com.example.manageruniversity.university.exam.vo.TestUpdateReqVO;
import com.example.manageruniversity.university.exam.vo.TestReqVO;

import java.util.List;

public interface TestService {
    void create(TestReqVO testReqVO);
    void updateRoom(Long testId, Long roomId);
    List<Test> getAllBySchoolYearIdAndStudentId(Long schoolYearId, String studentId);
    void addStudentIntoTest(TestUpdateReqVO request);
    void removeStudentFromTest(TestUpdateReqVO request);
}
