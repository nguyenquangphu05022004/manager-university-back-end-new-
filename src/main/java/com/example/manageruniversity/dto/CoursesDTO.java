package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Data
public class CoursesDTO extends BaseDTO {
    private String name;
    private String code;
    private List<SeasonDTO> seasonsDto = new ArrayList<>();

}
