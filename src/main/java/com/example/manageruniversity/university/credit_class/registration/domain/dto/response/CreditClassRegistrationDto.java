package com.example.manageruniversity.university.credit_class.registration.domain.dto.response;

import com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassRegistration;
import com.example.manageruniversity.university.credit_class.self.CreditClassDto;
import com.example.manageruniversity.university.school_year.SchoolYearDto;

import java.time.LocalDateTime;

import static com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassRegistration.Status;

public class CreditClassRegistrationDto {
    private CreditClassDto creditClass;
    private SchoolYearDto schoolYear;
    private Status status;
    private LocalDateTime modifiedAt;


    public CreditClassRegistrationDto(CreditClassRegistration registration) {
        this.creditClass = new CreditClassDto(registration.getCreditClass());
        this.schoolYear = new SchoolYearDto(registration.getSchoolYear());
        this.status = registration.getStatus();
        this.modifiedAt = registration.getModifiedDate();
    }
}
