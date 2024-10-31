package com.example.manageruniversity.core.instruction.repository;

import com.example.manageruniversity.core.instruction.domain.entity.MajorSubjectSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MajorSubjectSelectionRepository extends
        JpaRepository<MajorSubjectSelection, Long>,
        JpaSpecificationExecutor<MajorSubjectSelection> {
}
