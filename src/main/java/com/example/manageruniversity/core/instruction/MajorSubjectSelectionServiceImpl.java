package com.example.manageruniversity.core.instruction;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.pojo.PageConstant;
import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.course.CourseService;
import com.example.manageruniversity.core.major.Major;
import com.example.manageruniversity.core.major.MajorService;
import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.core.school_year.SchoolYearService;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.core.subject.SubjectDto;
import com.example.manageruniversity.core.subject.SubjectService;
import com.example.manageruniversity.filter.Condition;
import com.example.manageruniversity.filter.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorSubjectSelectionServiceImpl implements MajorSubjectSelectionService {
    private final MajorSubjectSelectionRepository majorSubjectSelectionRepository;
    private final CourseService courseService;
    private final SchoolYearService schoolYearService;
    private final MajorService majorService;
    private final SubjectService subjectService;

    @Override
    @Transactional
    public MajorSubjectSelection create(MajorSubjectSelectionRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        Course course = courseService.getById(request.getCourseId());
        SchoolYear schoolYear = schoolYearService.getById(request.getSchoolYearId());
        Major major = majorService.getById(request.getMajorId());
        Set<Subject> subjects = request.getSubjectIds().stream()
                .map(s -> this.subjectService.getById(s))
                .collect(Collectors.toSet());
        MajorSubjectSelection mssl = new MajorSubjectSelection(
                major,
                course,
                schoolYear,
                subjects,
                false
        );
        this.majorSubjectSelectionRepository.save(mssl);
        return mssl;
    }

    @Override
    public void delete(Long majorSSlId) {
        this.majorSubjectSelectionRepository.deleteById(majorSSlId);
    }

    @Override
    public List<MajorSubjectSelection> findAllByCondition(Condition condition) {
        return majorSubjectSelectionRepository.findAll(Filter.filterAllCondition(condition));
    }

    @Override
    public void removeSubject(Long majorSelectionId, String subjectId) {

    }

    @Override
    public void addSubject(AddSubjectRequest request) {

    }

    @Override
    public List<MajorSubjectSelection> getAll() {
        return this.majorSubjectSelectionRepository.findAll();
    }
}
