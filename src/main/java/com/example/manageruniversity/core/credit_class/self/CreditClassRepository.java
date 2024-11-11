package com.example.manageruniversity.core.credit_class.self;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditClassRepository extends JpaRepository<CreditClass, Long> {
    List<CreditClass> findAllBySchoolYearId(Long schoolYearId);
    List<CreditClass> findAllBySchoolYearIdAndTeacherPersonId(
            Long schoolYearId,
            String teacherId);

    @Query("select c from CreditClass c where c.schoolYear.id = :schoolYearId and \n" +
            "c.id in (select cm.creditClass.id from CreditClassRegistration cm \n" +
            "where cm.student.personId = :studentId)")
    List<CreditClass> findAllBySchoolYearAndThatWereSelectedByStudentId(
            @Param("schoolYearId") Long schoolYearId,
            @Param("studentId") String studentId);

}
