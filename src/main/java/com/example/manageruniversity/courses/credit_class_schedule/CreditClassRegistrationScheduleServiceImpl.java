package com.example.manageruniversity.courses.credit_class_schedule;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.pojo.PageConstant;
import com.example.manageruniversity.core.course.service.CourseService;
import com.example.manageruniversity.core.major.service.MajorService;
import com.example.manageruniversity.core.schoolYear.service.SchoolYearService;
import com.example.manageruniversity.courses.credit_class_schedule.repo.CreditClassRegistrationScheduleRepository;
import com.example.manageruniversity.filter.Condition;
import com.example.manageruniversity.filter.FilterFactory;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditClassRegistrationScheduleServiceImpl
        implements CreditClassRegistrationScheduleService {
    private final SchoolYearService schoolYearService;
    private final MajorService majorService;
    private final CourseService courseService;
    private final CreditClassRegistrationScheduleRepository creditClassRegistrationScheduleRepository;
    @Override
    public CreditClassRegistrationSchedule create(CreditClassRegistrationScheduleRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        CreditClassRegistrationSchedule schedule = new CreditClassRegistrationSchedule(
                this.schoolYearService.getById(request.getSchoolYearId()),
                this.majorService.getById(request.getMajorId()),
                request.getStart(),
                request.getEnd(),
                this.courseService.getById(request.getCourseId())
        );
        this.creditClassRegistrationScheduleRepository.save(schedule);
        return schedule;
    }


    @Override
    public Page<CreditClassRegistrationSchedule> getAllBySchoolYearId(Long schoolYearId, int page) {
        return this.creditClassRegistrationScheduleRepository.findAllBySchoolYearId(
                schoolYearId,
                PageRequest.of(page - 1, PageConstant.LIMIT)
        );
    }

    @Override
    public Page<CreditClassRegistrationSchedule> getAllByMajorId(String majorId, int page) {
        return this.creditClassRegistrationScheduleRepository.findAllByMajorMajorId(
                majorId,
                PageRequest.of(page - 1, PageConstant.LIMIT)
        );
    }
}
