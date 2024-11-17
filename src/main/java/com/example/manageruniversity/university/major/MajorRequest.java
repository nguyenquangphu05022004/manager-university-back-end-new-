package com.example.manageruniversity.university.major;

import lombok.Data;

@Data
public class MajorRequest {
    private String majorId;
    private String name;
    private String majorParentId;
}
