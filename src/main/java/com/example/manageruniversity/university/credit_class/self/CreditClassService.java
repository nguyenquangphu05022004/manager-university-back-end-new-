package com.example.manageruniversity.university.credit_class.self;

import java.util.List;

public interface CreditClassService {
    CreditClass createOrUpdate(CreditClassRequest request);
    void delete(Long creditClassId);
    List<CreditClass> getAllBySchoolYearId(Long schoolYearId);
    List<CreditClass> getAllBySchoolYearIdAndTeacherId(Long schoolYearId, Long teacherId);
    List<CreditClass> getAllBySchoolYearIdThatWereSelectedByStudentId(Long schoolYearId, Long studentId);
    CreditClass getById(Long id);
}
