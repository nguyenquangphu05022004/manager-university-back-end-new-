package com.example.manageruniversity.university.tuition.dal.repo;

import com.example.manageruniversity.university.tuition.dal.dataobject.AmountPerCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountPerCreditRepository extends JpaRepository<AmountPerCredit, Long> {
    AmountPerCredit findBySchoolYearIdAndMajorMajorIdAndCourseCourseId(
            Long schoolYearId,
            String majorId,
            String courseId
    );
}
