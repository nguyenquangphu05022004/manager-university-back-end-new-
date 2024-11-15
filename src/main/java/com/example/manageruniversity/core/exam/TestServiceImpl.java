package com.example.manageruniversity.core.exam;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.core.credit_class.self.CreditClass;
import com.example.manageruniversity.core.credit_class.self.CreditClassRepository;
import com.example.manageruniversity.core.exam.vo.TestUpdateReqVO;
import com.example.manageruniversity.core.exam.vo.TestReqVO;
import com.example.manageruniversity.core.member.dal.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import static com.example.manageruniversity.common.collection.ListUtils.*;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{
    private final TestRepository testRepository;
    private final CreditClassRepository creditClassRepository;

    @Override
    public void create(TestReqVO testReqVO) {
        /**
         * Lay toan bo lop hoc ung voi mon hoc
         * va hoc ky do
         */
        List<CreditClass> creditClasses = this.creditClassRepository.findAllBySchoolYearIdAndSubjectSubjectId(
                testReqVO.getSchoolYearId(),
                testReqVO.getSubjectId()
        );

        /**
         * Lay toan bo sinh vien da hoc trong
         * cac lop tin chi
         */
        List<Student> students = convertToList2(creditClasses, creditClass -> creditClass.getStudents());

        /**
         * So luong sinh vien moi phong thi
         */
        int maxSize =  testReqVO.getNumberOfStudent();
        /**
         * Gioi han sinh vien trong moi phong kiem tra
         */
        List<List<Student>> partition = partition(students, maxSize);

        partition.stream().forEach(st -> {
            Test test = new Test(
                    testReqVO.getSubjectId(),
                    testReqVO.getStartDate(),
                    testReqVO.getStartTime(),
                    testReqVO.getInMinutes(),
                    testReqVO.getFormat(),
                    testReqVO.getSchoolYearId(),
                    new HashSet<>(st)
            );
            this.testRepository.save(test);
        });
    }

    @Override
    public void updateRoom(Long testId, Long roomId) {
        Test test = this.testRepository.findById(testId)
                .orElseThrow(() -> new ResourcesNotFoundException("not found"));



    }

    @Override
    public List<Test> getAllBySchoolYearIdAndStudentId(Long schoolYearId, String studentId) {
        return null;
    }

    @Override
    public void addStudentIntoTest(TestUpdateReqVO request) {

    }

    @Override
    public void removeStudentFromTest(TestUpdateReqVO request) {

    }

}
