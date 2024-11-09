package com.example.manageruniversity.core.instruction;

import lombok.Data;

import java.util.Set;

@Data
public class AddSubjectRequest {
    private Long majorSelectionId;
    private Set<String> subjectIds;
}
