package com.example.manageruniversity.core.credit_class;

import java.util.List;

public interface CreditClassService {
    CreditClass createOrUpdate(CreditClassRequest request);
    void delete(Long creditClassId);
    List<CreditClass> getAllBySchoolYearId(Long schoolYearId);
    List<CreditClass> getAllBySchoolYearIdAndTeacherId(Long schoolYearId, String teacherId);
    List<CreditClass> getAllBySchoolYearIdThatWereSelectedByStudentId(Long schoolYearId, String studentId);
    CreditClass getById(Long id);
}
