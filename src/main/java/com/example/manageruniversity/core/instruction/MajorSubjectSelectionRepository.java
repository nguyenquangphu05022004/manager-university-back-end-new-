package com.example.manageruniversity.core.instruction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MajorSubjectSelectionRepository extends
        JpaRepository<MajorSubjectSelection, Long>,
        JpaSpecificationExecutor<MajorSubjectSelection> {
    List<MajorSubjectSelection> findAllBySchoolYearIdAndCourseCourseId(Long schoolYearId, String courseId);
}
