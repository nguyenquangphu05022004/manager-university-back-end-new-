package com.example.manageruniversity.university.credit_class.registration_schedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditClassRegistrationScheduleRepository extends JpaRepository<CreditClassRegistrationSchedule, Long> {
    List<CreditClassRegistrationSchedule> findAllBySchoolYearId(Long schoolYearId);
    List<CreditClassRegistrationSchedule> findAllByMajorMajorId(String majorId);
}
