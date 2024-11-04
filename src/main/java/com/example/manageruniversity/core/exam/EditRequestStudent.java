package com.example.manageruniversity.core.exam;

import lombok.Data;

import java.util.Set;

@Data
public class EditRequestStudent {
    private Long testId;
    private Set<String> usersId;
}
