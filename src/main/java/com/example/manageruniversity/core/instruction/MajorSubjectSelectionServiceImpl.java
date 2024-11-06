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
import com.example.manageruniversity.core.subject.SubjectService;
import com.example.manageruniversity.filter.Condition;
import com.example.manageruniversity.filter.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public MajorSubjectSelection create(MajorSubjectSelectionRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        Course course = courseService.getById(request.getCourseId());
        SchoolYear schoolYear = schoolYearService.getById(request.getSchoolYearId());
        Major major = majorService.getById(request.getMajorId());
        Subject subject = subjectService.getById(request.getSubjectId());
        MajorSubjectSelection mssl = new MajorSubjectSelection(
                major, subject, course, schoolYear, request.isStatus()
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
}
