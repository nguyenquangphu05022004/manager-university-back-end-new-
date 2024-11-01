package com.example.manageruniversity.exam.domain.request;

import lombok.Data;

import java.util.Set;

@Data
public class EditRequestStudent {
    private Long testId;
    private Set<String> usersId;
}
