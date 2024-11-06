package com.example.manageruniversity.core.credit_class;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.pojo.PageConstant;
import com.example.manageruniversity.core.credit_class.time_table.TimeTableRepository;
import com.example.manageruniversity.core.credit_class.time_table.TimeTableService;
import com.example.manageruniversity.core.school_year.SchoolYearService;
import com.example.manageruniversity.core.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Page<CreditClass> getAllBySchoolYearId(Long schoolYearId, int page) {
        return this.creditClassRepository
                .findAllBySchoolYearId(
                        schoolYearId,
                        PageRequest.of(page - 1, PageConstant.LIMIT)
                );
    }

    @Override
    public Page<CreditClass> getAllBySchoolYearIdAndTeacherId(Long schoolYearId, String teacherId, int page) {
        return this.creditClassRepository
                .findAllBySchoolYearIdAndTeacherPersonId(
                        schoolYearId,
                        teacherId,
                        PageRequest.of(page - 1, PageConstant.LIMIT)
                );
    }


    @Override
    public Page<CreditClass> getAllBySchoolYearIdThatWereSelectedByStudentId(Long schoolYearId, String studentId, int page) {
        return this.creditClassRepository.findAllBySchoolYearAndThatWereSelectedByStudentId(
                schoolYearId,
                studentId,
                PageRequest.of(page - 1, PageConstant.LIMIT)
        );
    }

    @Override
    public CreditClass getById(Long id) {
        return this.creditClassRepository
                .findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("credit class not found"));
    }
}
