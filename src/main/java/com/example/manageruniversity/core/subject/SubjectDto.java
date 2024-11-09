package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.common.object.ObjectUtils;
import lombok.Getter;

@Getter
public class SubjectDto {
    private String subjectId;
    private String name;
    private Integer credit;

    public SubjectDto(Subject subject) {
        if(ObjectUtils.isNull(subject)) return;
        this.subjectId = subject.getSubjectId();
        this.name = subject.getSubjectName();
        this.credit = subject.getCredit();
    }
}
