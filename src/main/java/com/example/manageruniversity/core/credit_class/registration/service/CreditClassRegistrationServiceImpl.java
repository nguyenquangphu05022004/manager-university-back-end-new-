package com.example.manageruniversity.core.credit_class.registration.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.exception.ServiceException;
import com.example.manageruniversity.common.exception.TimeOverlapException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.credit_class.registration.domain.dto.request.CreditClassRegistrationReqVO;
import com.example.manageruniversity.core.credit_class.registration.domain.entities.CreditClassRegistration;
import com.example.manageruniversity.core.credit_class.registration.repo.CreditClassRegistrationRepository;
import com.example.manageruniversity.core.credit_class.self.CreditClass;
import com.example.manageruniversity.core.credit_class.self.CreditClassRepository;
import com.example.manageruniversity.core.member.dal.entities.Student;
import com.example.manageruniversity.core.member.dal.repo.StudentRepository;
import com.example.manageruniversity.core.school_year.SchoolYear;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.manageruniversity.common.collection.ListUtils.convertToList;
import static com.example.manageruniversity.common.date.DateTimeUtils.isBetween;
import static com.example.manageruniversity.core.credit_class.registration.domain.entities.CreditClassRegistration.Status.ACCEPT;

@Service
@RequiredArgsConstructor
public class CreditClassRegistrationServiceImpl implements CreditClassRegistrationService{
    private final CreditClassRegistrationRepository creditClassRegistrationRepository;
    private final CreditClassRepository creditClassRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public CreditClassRegistration create(CreditClassRegistrationReqVO request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourcesNotFoundException("not found student"));

        CreditClass creditClassWantRegister = this.creditClassRepository
                .findById(request.getCreditClassId())
                .orElseThrow(() -> new ResourcesNotFoundException("not found credit class, please check again"));
        //add student into class
        creditClassWantRegister.addStudent(student);

        List<CreditClass> creditClasses = convertToList(
                this.getListByStudentIdAndSchoolYearId(request.getStudentId(),
                        request.getSchoolYearId()), c -> c.getCreditClass()
        );
        //kiem tra xem lich hoc co bi trung khong
        boolean isOverloadTime = creditClasses.stream()
                .allMatch(creditClassThatRegistered -> creditClassThatRegistered.getTimeTables()
                            .stream()
                            .anyMatch(timeTable -> creditClassWantRegister.getTimeTables()
                                        .stream()
                                        .anyMatch(time -> {
                                            if (time.getDayOfWeek().compareTo(timeTable.getDayOfWeek()) == 0) {
                                                return isBetween(time.getStartTime(), timeTable.getStartTime(), time.getEndTime())
                                                        || isBetween(time.getEndTime(), timeTable.getStartTime(), timeTable.getEndTime());
                                            }
                                            return false;
                                        })
                            )
                );
        if(isOverloadTime) {
            throw new TimeOverlapException("Your credit class is overloaded lesson, please choose another credit class.");
        }

        CreditClassRegistration creditClassRegistration = new CreditClassRegistration(
               student,
                new SchoolYear(request.getSchoolYearId()),
                creditClassWantRegister
        );

        this.creditClassRegistrationRepository.save(creditClassRegistration);
        this.creditClassRepository.save(creditClassWantRegister);
        return creditClassRegistration;
    }

    @Override
    public void delete(Long creditClassRegistrationId) {
        CreditClassRegistration creditClassRegistration = this.creditClassRegistrationRepository
                .findById(creditClassRegistrationId)
                .orElseThrow(() -> new ResourcesNotFoundException("not found record"));
        if(creditClassRegistration.getStatus() == ACCEPT) {
            throw new ServiceException("You can't delete record");
        }
        this.creditClassRegistrationRepository.delete(creditClassRegistration);
    }

    @Override
    public List<CreditClassRegistration> getListByStudentIdAndSchoolYearId(Long studentId, Long schoolYearId) {
        return this.creditClassRegistrationRepository.findAllByStudentIdAndSchoolYearId(studentId, schoolYearId);
    }
}
