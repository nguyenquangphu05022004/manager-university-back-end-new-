package com.example.manageruniversity.core.major.domain.dto;


import com.example.manageruniversity.core.major.domain.entity.Major;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MajorDto {
    private String majorId;
    private String name;

    public MajorDto(Major major) {
        if(major != null) {
            majorId = major.getMajorId();
            name = major.getName();
        }
    }
}
