package com.example.manageruniversity.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CommonResult<T> {
    private String message;
    private Integer code;
    private T data;

    public static <T> CommonResult<T> success(Integer code, String message, T data) {
        return new CommonResult<>(message, code, data);
    };

    public static <T> CommonResult<T> success(Integer code) {
        return success(code, null, null);
    }

    public static <T> CommonResult<T> success(T data) {
        return success(200, null, data);
    }


    public static <T> CommonResult<T> success(Integer code, T data) {
        return success(code, null, data);
    }

    public static <T> CommonResult<T> error(T exception) {
        return new CommonResult<>(null, null, exception);
    }
}
