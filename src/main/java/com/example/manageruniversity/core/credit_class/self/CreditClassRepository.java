package com.example.manageruniversity.core.credit_class.self;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditClassRepository extends JpaRepository<CreditClass, Long> {
    List<CreditClass> findAllBySchoolYearId(Long schoolYearId);
    List<CreditClass> findAllBySchoolYearIdAndTeacherId(
            Long schoolYearId,
            Long teacherId);

    @Query("select c from CreditClass c where c.schoolYear.id = :schoolYearId and \n" +
            "c.id in (select cm.creditClass.id from CreditClassRegistration cm \n" +
            "where cm.student.id = :studentId)")
    List<CreditClass> findAllBySchoolYearAndThatWereSelectedByStudentId(
            @Param("schoolYearId") Long schoolYearId,
            @Param("studentId") Long studentId);

    List<CreditClass> findAllBySchoolYearIdAndSubjectSubjectId(Long schoolYearId, String subjectId);
}
