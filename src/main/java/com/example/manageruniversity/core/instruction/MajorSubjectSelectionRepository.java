package com.example.manageruniversity.core.instruction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MajorSubjectSelectionRepository extends
        JpaRepository<MajorSubjectSelection, Long>,
        JpaSpecificationExecutor<MajorSubjectSelection> {
}
