package com.example.manageruniversity.dto;

public enum EnumGrade {
    A_PLUS(4.0f), A(3.7f),
    B_PLUS(3.5f), B(3.0f),
    C_PLUS(2.5f), C(2.0f),
    D_PLUS(1.5f), D(1f),
    F(0);

    private float value;

    EnumGrade(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
