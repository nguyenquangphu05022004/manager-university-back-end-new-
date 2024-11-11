package com.example.manageruniversity.core.credit_class.registration.repo;

import com.example.manageruniversity.core.credit_class.registration.domain.entities.CreditClassRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CreditClassRegistrationRepository extends JpaRepository<CreditClassRegistration, Long> {

    @Query("select c from CreditClassRegistration c where c.student.personId = :studentId " +
            "and c.creditClass.id = :creditClassId")
    Optional<CreditClassRegistration> findByStudentIdAndCreditClassId(
            String studentId,
            Long creditClassId
    );


    @Query("select c from CreditClassRegistration c \n" +
            "where c.student.personId = :studentId and c.schoolYear.id = :schoolYearId")
    List<CreditClassRegistration> findAllByStudentIdAndSchoolYearId(String studentId,
                                                                    Long schoolYearId);

}
