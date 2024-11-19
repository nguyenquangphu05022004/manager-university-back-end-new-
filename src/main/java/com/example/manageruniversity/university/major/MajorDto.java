package com.example.manageruniversity.university.major;


import com.example.manageruniversity.common.excel.annotation.ExcelProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MajorDto {
    @ExcelProperties(column = "Ma mon hoc")
    private String majorId;
    @ExcelProperties(column = "Ten nganh")
    private String name;

    public MajorDto(Major major) {
        if(major != null) {
            majorId = major.getMajorId();
            name = major.getName();
        }
    }
}
