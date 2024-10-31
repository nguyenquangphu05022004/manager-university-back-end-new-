package com.example.manageruniversity.core.subject.domain.dto;

import com.example.manageruniversity.core.subject.domain.entity.Subject;
import lombok.Getter;

@Getter
public class SubjectDto {
    private String subjectId;
    private String name;
    private Short credit;

    public SubjectDto(Subject subject) {
        this.subjectId = subject.getSubjectId();
        this.name = subject.getSubjectName();
        this.credit = subject.getCredit();
    }
}
