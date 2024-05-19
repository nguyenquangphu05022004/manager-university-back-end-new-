package com.example.manageruniversity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO extends BaseDTO{
    private RegisterDTO registerDTO;
    private Long studentRequest;

}
