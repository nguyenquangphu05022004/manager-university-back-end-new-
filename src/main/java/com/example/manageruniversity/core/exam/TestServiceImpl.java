package com.example.manageruniversity.core.exam;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.pojo.PageConstant;
import com.example.manageruniversity.core.school_year.SchoolYearService;
import com.example.manageruniversity.core.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<Test> getAllBySchoolYearIdAndStudentId(Long schoolYearId, String studentId, int page) {
        return this.testRepository.findAllBySchoolYearIdAndContainsStudentId(schoolYearId, studentId, PageRequest.of(page - 1, PageConstant.LIMIT));
    }

    @Override
    public void addStudentIntoTest(EditRequestStudent request) {

    }

    @Override
    public void removeStudentFromTest(EditRequestStudent request) {

    }


}
