package com.example.manageruniversity.core.credit_class;

import org.springframework.data.domain.Page;

public interface CreditClassService {
    CreditClass createOrUpdate(CreditClassRequest request);
    void delete(Long creditClassId);
    Page<CreditClass> getAllBySchoolYearId(Long schoolYearId, int page);
    Page<CreditClass> getAllBySchoolYearIdAndTeacherId(Long schoolYearId, String teacherId, int page);
    Page<CreditClass> getAllBySchoolYearIdThatWereSelectedByStudentId(Long schoolYearId, String studentId, int page);
    CreditClass getById(Long id);
}
