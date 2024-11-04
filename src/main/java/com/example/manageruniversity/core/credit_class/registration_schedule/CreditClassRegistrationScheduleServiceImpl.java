package com.example.manageruniversity.core.credit_class.registration_schedule;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.pojo.PageConstant;
import com.example.manageruniversity.core.course.CourseService;
import com.example.manageruniversity.core.major.MajorService;
import com.example.manageruniversity.core.school_year.SchoolYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
