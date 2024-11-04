package com.example.manageruniversity.core.major;

import lombok.Data;

@Data
public class MajorRequest {
    private String majorId;
    private String name;
    private String majorParentId;
}
