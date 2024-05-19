package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegisterDTO extends BaseDTO{
    private StudentDTO studentDTO;
    private SubjectGroupDTO subjectGroup;
    private boolean openTransaction;
    private GradeDTO grade;
    private MajorRegisterDTO majorRegisterDTO;
    private List<TransactionDTO> transactionList = new ArrayList<>();


}
