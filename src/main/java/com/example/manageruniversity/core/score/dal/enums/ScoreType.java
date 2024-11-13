package com.example.manageruniversity.core.score.dal.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ScoreType {
    ATTENDANCE(1, "chuyen can"),
    MIDTERM(2, "giua ky"),
    FINAL(3, "cuoi ky"),
    PRACTICE(4, "thuc hanh");

    private final Integer index;
    private final String value;
}
