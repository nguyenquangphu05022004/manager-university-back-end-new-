package com.example.manageruniversity.core.credit_class.registration.service;

import com.example.manageruniversity.core.credit_class.registration.domain.dto.request.CreditClassRegistrationReqVO;
import com.example.manageruniversity.core.credit_class.registration.domain.entities.CreditClassRegistration;

import java.util.List;

public interface CreditClassRegistrationService {
    CreditClassRegistration create(CreditClassRegistrationReqVO request);
    void delete(Long creditClassRegistrationId);
    List<CreditClassRegistration> getListByStudentIdAndSchoolYearId(Long studentId, Long schoolYearId);
}
