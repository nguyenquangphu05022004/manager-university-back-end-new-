package com.example.manageruniversity.university.credit_class.registration.repo;

import com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CreditClassRegistrationRepository extends JpaRepository<CreditClassRegistration, Long> {

    Optional<CreditClassRegistration> findByStudentIdAndCreditClassId(
            Long studentId,
            Long creditClassId
    );


    List<CreditClassRegistration> findAllBySchoolYearId(Long schoolYearId);

    List<CreditClassRegistration> findAllByStudentIdAndSchoolYearId(Long studentId, Long schoolYearId);

}
