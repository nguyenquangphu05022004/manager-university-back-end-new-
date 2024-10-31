package com.example.manageruniversity.core.major.domain.request;

import lombok.Data;

@Data
public class MajorRequest {
    private String majorId;
    private String name;
    private String majorParentId;
}
