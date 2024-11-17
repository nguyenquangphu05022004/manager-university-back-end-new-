package com.example.manageruniversity.common.exception.yu;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorCode {
    private Integer code;
    private String message;
}
