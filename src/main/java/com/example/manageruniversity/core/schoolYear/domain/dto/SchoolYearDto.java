package com.example.manageruniversity.core.schoolYear.domain.dto;

import com.example.manageruniversity.core.schoolYear.domain.entity.SchoolYear;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolYearDto {
    private Long id;
    private String name;
    private String semester;

    public SchoolYearDto(SchoolYear schoolYear) {
        if(schoolYear != null) {
            id = schoolYear.getId();
            name = schoolYear.getFrom() + " - " + schoolYear.getTo();
            semester = schoolYear.getSemester().getValue();
        }
    }
}
