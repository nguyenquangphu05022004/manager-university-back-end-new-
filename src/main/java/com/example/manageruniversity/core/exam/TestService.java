package com.example.manageruniversity.core.exam;

import com.example.manageruniversity.core.exam.vo.TestUpdateReqVO;
import com.example.manageruniversity.core.exam.vo.TestReqVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TestService {
    void create(TestReqVO testReqVO);
    void updateRoom(Long testId, Long roomId);
    List<Test> getAllBySchoolYearIdAndStudentId(Long schoolYearId, String studentId);
    void addStudentIntoTest(TestUpdateReqVO request);
    void removeStudentFromTest(TestUpdateReqVO request);
}
