package com.example.manageruniversity.university.exam.vo;

import com.example.manageruniversity.university.subject.SubjectDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TestResVO extends TestBaseVO{
    private Long id;
    @Schema(description = "thong tin ve mon hoc")
    private SubjectDto subject;
}
