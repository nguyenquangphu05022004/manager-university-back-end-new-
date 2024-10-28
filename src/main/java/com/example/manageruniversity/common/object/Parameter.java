package com.example.manageruniversity.common.object;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Parameter {
    private Class<?>[] classes;
    private Object[] objects;
}
