package com.example.manageruniversity.core.exam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long> {
//    Page<Test> findAllBySchoolYearIdAndContainsStudentId(Long schoolYearId, String studentId, Pageable pageable);
}
