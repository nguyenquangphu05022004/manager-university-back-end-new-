package com.example.manageruniversity.university.exam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
//    Page<Test> findAllBySchoolYearIdAndContainsStudentId(Long schoolYearId, String studentId, Pageable pageable);
}
