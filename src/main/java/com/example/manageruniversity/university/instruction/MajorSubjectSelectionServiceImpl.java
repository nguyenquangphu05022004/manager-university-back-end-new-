package com.example.manageruniversity.university.instruction;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.university.course.Course;
import com.example.manageruniversity.university.course.CourseService;
import com.example.manageruniversity.university.major.Major;
import com.example.manageruniversity.university.major.MajorService;
import com.example.manageruniversity.university.school_year.SchoolYear;
import com.example.manageruniversity.university.school_year.SchoolYearService;
import com.example.manageruniversity.university.subject.Subject;
import com.example.manageruniversity.university.subject.SubjectService;
import lombok.RequiredArgsConstructor;
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

//    @Override
//    public List<MajorSubjectSelection> findAllByCondition(Condition condition) {
//        return majorSubjectSelectionRepository.findAll(Filter.filterAllCondition(condition));
//    }

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
