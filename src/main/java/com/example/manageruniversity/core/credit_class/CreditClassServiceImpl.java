package com.example.manageruniversity.core.credit_class;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.credit_class.time_table.TimeTableRepository;
import com.example.manageruniversity.core.school_year.SchoolYearService;
import com.example.manageruniversity.core.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditClassServiceImpl implements CreditClassService{
    private final CreditClassRepository creditClassRepository;
    private final SubjectService subjectService;
    private final SchoolYearService schoolYearService;
    private final TimeTableRepository timeTableRepository;
    @Override
    public CreditClass createOrUpdate(CreditClassRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request, "id");
        CreditClass creditClass = new CreditClass(
                request.getMaxStudent(),
                null,
                subjectService.getById(request.getSubjectId()),
                schoolYearService.getById(request.getSchoolYearId()),
                request.getGroup()
        );
        return creditClassRepository.save(creditClass);
    }

    @Override
    @Transactional
    public void delete(Long creditClassId) {
        this.timeTableRepository.deleteAllByCreditClassId(creditClassId);
        this.creditClassRepository.deleteById(creditClassId);
    }

    @Override
    public List<CreditClass> getAllBySchoolYearId(Long schoolYearId) {
        return this.creditClassRepository.findAllBySchoolYearId(schoolYearId);
    }

    @Override
    public List<CreditClass> getAllBySchoolYearIdAndTeacherId(Long schoolYearId, String teacherId) {
        return this.creditClassRepository
                .findAllBySchoolYearIdAndTeacherPersonId(
                        schoolYearId,
                        teacherId
                );
    }


    @Override
    public List<CreditClass> getAllBySchoolYearIdThatWereSelectedByStudentId(
            Long schoolYearId, String studentId) {
        return this.creditClassRepository.findAllBySchoolYearAndThatWereSelectedByStudentId(
                schoolYearId,
                studentId
        );
    }

    @Override
    public CreditClass getById(Long id) {
        return this.creditClassRepository
                .findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("credit class not found"));
    }
}
