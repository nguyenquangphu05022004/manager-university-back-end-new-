package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.common.object.ObjectUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Schema(name = "Subject - Mon hoc")
public class SubjectDto {

    @Schema(description = "Ma hoc hoc", example = "BAS1000")
    @NotNull(message = "Subject Id can't null")
    private String subjectId;
    @Schema(description = "Ten cua mon hoc", example = "C++")
    @NotNull(message = "Name can't null")
    private String name;
    @Schema(description = "So tin chi cua mon hoc", example = "3")
    @NotNull(message = "Credit can't null")
    private Integer credit;

    public SubjectDto(Subject subject) {
        if(ObjectUtils.isNull(subject)) return;
        this.subjectId = subject.getSubjectId();
        this.name = subject.getSubjectName();
        this.credit = subject.getCredit();
    }
}
