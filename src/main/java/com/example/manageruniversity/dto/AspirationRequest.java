package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AspirationRequest {
    private String studentCode;//this field is username
    private String subjectCode;
    private Long seasonId;
}
