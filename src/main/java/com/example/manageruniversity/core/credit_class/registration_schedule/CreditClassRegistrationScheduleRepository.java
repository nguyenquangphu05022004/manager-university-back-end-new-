package com.example.manageruniversity.core.credit_class.registration_schedule;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditClassRegistrationScheduleRepository extends JpaRepository<CreditClassRegistrationSchedule, Long> {
    Page<CreditClassRegistrationSchedule> findAllBySchoolYearId(Long schoolYearId, Pageable pageable);
    Page<CreditClassRegistrationSchedule> findAllByMajorMajorId(String majorId, Pageable pageable);
}
