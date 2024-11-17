package com.example.manageruniversity.university.credit_class.registration_schedule;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.university.course.CourseService;
import com.example.manageruniversity.university.major.MajorService;
import com.example.manageruniversity.university.school_year.SchoolYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CreditClassRegistrationSchedule> getAllBySchoolYearId(Long schoolYearId) {
        return this.creditClassRegistrationScheduleRepository.findAllBySchoolYearId(schoolYearId);
    }

    @Override
    public List<CreditClassRegistrationSchedule> getAllByMajorId(String majorId) {
        return this.creditClassRegistrationScheduleRepository.findAllByMajorMajorId(majorId);
    }
}
