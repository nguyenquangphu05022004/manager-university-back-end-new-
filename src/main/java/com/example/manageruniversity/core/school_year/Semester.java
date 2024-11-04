package com.example.manageruniversity.core.school_year;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.collection.StreamUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Semester {
    SEMESTER_1(1,"Học kỳ 1"),
    SEMESTER_2(2,"Học kỳ 2"),
    SEMESTER_3(3, "Học kỳ 3");
    private final Integer index;
    private final String value;


    public static Semester findByIndex(int index) {
        return StreamUtils.findFirst(
                ListUtils.toList(Semester.values()),
                (s) -> s.index == index
        );
    }
}
