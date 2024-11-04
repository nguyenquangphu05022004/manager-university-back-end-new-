package com.example.manageruniversity.core.subject;

import lombok.Getter;

@Getter
public class SubjectDto {
    private String subjectId;
    private String name;
    private Integer credit;

    public SubjectDto(Subject subject) {
        this.subjectId = subject.getSubjectId();
        this.name = subject.getSubjectName();
        this.credit = subject.getCredit();
    }
}
