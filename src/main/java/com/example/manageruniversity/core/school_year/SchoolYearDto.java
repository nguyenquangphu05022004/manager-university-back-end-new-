package com.example.manageruniversity.core.school_year;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema
public class SchoolYearDto {
    @Schema(description = "ma hoc ky")
    private Long id;
    @Schema(description = "ten hoc nam hoc", example = "2022-2023")
    private String name;
    @Schema(description = "ten hoc ky", example = "Học kỳ 2")
    private String semester;

    public SchoolYearDto(SchoolYear schoolYear) {
        if(schoolYear != null) {
            id = schoolYear.getId();
            name = schoolYear.getFromYear() + " - " + schoolYear.getToYear();
            semester = schoolYear.getSemester().getValue();
        }
    }
}
