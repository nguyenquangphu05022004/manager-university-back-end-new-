package com.example.manageruniversity.core.exam.vo;

import com.example.manageruniversity.core.subject.SubjectDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TestResVO extends TestBaseVO{
    private Long id;
    @Schema(description = "thong tin ve mon hoc")
    private SubjectDto subject;
}
