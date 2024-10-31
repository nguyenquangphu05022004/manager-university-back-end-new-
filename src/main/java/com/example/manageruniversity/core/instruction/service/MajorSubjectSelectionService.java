package com.example.manageruniversity.core.instruction.service;

import com.example.manageruniversity.core.instruction.domain.dto.MajorSubjectSelectionDto;
import com.example.manageruniversity.core.instruction.domain.request.MajorSubjectSelectionRequest;
import com.example.manageruniversity.filter.Condition;

import java.util.List;

public interface MajorSubjectSelectionService {
    MajorSubjectSelectionDto create(MajorSubjectSelectionRequest request);
    void delete(Long majorSSlId);
    List<MajorSubjectSelectionDto> findAllByCondition(Condition condition);
}
