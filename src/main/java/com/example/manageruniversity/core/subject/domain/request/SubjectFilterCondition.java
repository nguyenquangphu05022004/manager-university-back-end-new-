package com.example.manageruniversity.core.subject.domain.request;

import lombok.Data;

@Data
public class SubjectFilterCondition {
    private String majorId;
    private String schoolYearId;
}
