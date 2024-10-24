package com.example.manageruniversity.core.schoolYear;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Semester {
    SEMESTER_1("Học kỳ 1"),
    SEMESTER_2("Học kỳ 2");

    @Getter
    private final String value;
}
