package com.example.manageruniversity.core.instruction.service;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.course.domain.entity.Course;
import com.example.manageruniversity.core.course.service.CourseService;
import com.example.manageruniversity.core.instruction.domain.dto.MajorSubjectSelectionDto;
import com.example.manageruniversity.core.instruction.domain.entity.MajorSubjectSelection;
import com.example.manageruniversity.core.instruction.domain.request.MajorSubjectSelectionRequest;
import com.example.manageruniversity.core.instruction.repository.MajorSubjectSelectionRepository;
import com.example.manageruniversity.core.major.domain.entity.Major;
import com.example.manageruniversity.core.major.service.MajorService;
import com.example.manageruniversity.core.schoolYear.domain.entity.SchoolYear;
import com.example.manageruniversity.core.schoolYear.service.SchoolYearService;
import com.example.manageruniversity.core.subject.domain.entity.Subject;
import com.example.manageruniversity.core.subject.service.SubjectService;
import com.example.manageruniversity.filter.Condition;
import com.example.manageruniversity.filter.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorSubjectSelectionServiceImpl implements MajorSubjectSelectionService {
    private final MajorSubjectSelectionRepository majorSubjectSelectionRepository;
    private final CourseService courseService;
    private final SchoolYearService schoolYearService;
    private final MajorService majorService;
    private final SubjectService subjectService;
    @Override
    public MajorSubjectSelectionDto create(MajorSubjectSelectionRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        Course course = courseService.getById(request.getCourseId());
        SchoolYear schoolYear = schoolYearService.getById(request.getSchoolYearId());
        Major major = majorService.getById(request.getMajorId());
        Subject subject = subjectService.getById(request.getSubjectId());
        MajorSubjectSelection mssl = new MajorSubjectSelection(
                major, subject, course, schoolYear, request.isStatus()
        );
        this.majorSubjectSelectionRepository.save(mssl);
        return new MajorSubjectSelectionDto(mssl);
    }

    @Override
    public void delete(Long majorSSlId) {
        this.majorSubjectSelectionRepository.deleteById(majorSSlId);
    }

    @Override
    public List<MajorSubjectSelectionDto> findAllByCondition(Condition condition) {
        List<MajorSubjectSelection> list = majorSubjectSelectionRepository
                .findAll(Filter.filterAllCondition(condition));
        return ListUtils.convert(
                MajorSubjectSelectionDto.class,
                list
        );
    }
}
