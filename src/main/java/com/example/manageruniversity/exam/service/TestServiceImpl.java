package com.example.manageruniversity.exam.service;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.schoolYear.service.SchoolYearService;
import com.example.manageruniversity.core.subject.service.SubjectService;
import com.example.manageruniversity.exam.domain.entity.Test;
import com.example.manageruniversity.exam.domain.request.EditRequestStudent;
import com.example.manageruniversity.exam.domain.request.TestRequest;
import com.example.manageruniversity.exam.repo.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{
    private final TestRepository testRepository;
    private final SubjectService subjectService;
    private final SchoolYearService schoolYearService;
    @Override
    public Test update(TestRequest testRequest) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(testRequest, "testId");
        Test test = new Test(
                subjectService.getById(testRequest.getSubjectId()),
                null,
                testRequest.getStartDate(),
                testRequest.getStartTime(),
                testRequest.getInMinutes(),
                testRequest.getFormat(),
                schoolYearService.getById(testRequest.getSchoolYearId()),
                null
        );
        this.testRepository.save(test);
        return test;
    }

    @Override
    public List<Test> getAllBySchoolYearIdAndStudentId(Long schoolYearId, String studentId) {
        return null;
    }

    @Override
    public void addStudentIntoTest(EditRequestStudent request) {

    }

    @Override
    public void removeStudentFromTest(EditRequestStudent request) {

    }


}
