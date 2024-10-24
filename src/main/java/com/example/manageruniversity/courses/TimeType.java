package com.example.manageruniversity.courses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TimeType {
    ON_SITE("Học trực tiếp"),
    REMOTE("Học trực tuyến"),
    PRACTICE("Thực hành");

    @Getter
    private final String value;

}
