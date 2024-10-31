package com.example.manageruniversity.core.schoolYear.domain.request;

import lombok.Data;

@Data
public class SchoolYearRequest {
    private Long id;
    private Integer from;
    private Integer to;
    private Integer semester;
}
