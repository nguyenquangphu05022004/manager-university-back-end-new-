package com.example.manageruniversity.core.credit_class.registration.service;

import com.example.manageruniversity.core.credit_class.registration.domain.dto.request.CreditClassRegistrationRequest;
import com.example.manageruniversity.core.credit_class.registration.domain.entities.CreditClassRegistration;

import java.util.List;

public interface CreditClassRegistrationService {
    CreditClassRegistration create(CreditClassRegistrationRequest request);
    void delete(Long creditClassRegistrationId);
    List<CreditClassRegistration> getListByStudentIdAndSchoolYearId(String studentId, Long schoolYearId);
}
