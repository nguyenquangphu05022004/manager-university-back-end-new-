package com.example.manageruniversity.core.credit_class;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CreditClassRepository extends JpaRepository<CreditClass, Long> {
    Page<CreditClass> findAllBySchoolYearId(Long schoolYearId, Pageable pageable);
    Page<CreditClass> findAllBySchoolYearIdAndTeacherPersonId(
            Long schoolYearId,
            String teacherId,
            Pageable pageable
    );

    @Query("select c from CreditClass c where c.schoolYear.id = :schoolYearId and \n" +
            "c.id in (select cm.creditClass.id from CreditClassRegistration cm \n" +
            "where cm.student.personId = :studentId)")
    Page<CreditClass> findAllBySchoolYearAndThatWereSelectedByStudentId(
            @Param("schoolYearId") Long schoolYearId,
            @Param("studentId") String studentId,
            Pageable pageable
    );

}
