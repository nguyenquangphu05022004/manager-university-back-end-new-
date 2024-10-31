package com.example.manageruniversity.filter;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.collection.StreamUtils;
import com.example.manageruniversity.common.string.StringUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FilterType {
    SubjectId(null),
    CourseId(CourseIdFilter.class),
    MajorId(MajorIdFilter.class),
    SchoolYearId(SchoolYearIdFilter.class),
    SubQuerySubject(null),
    SubQueryMajorId(null),
    SubQuerySchoolYearId(null),
    SubQueryCourseId(null);
    @Getter
    private final Class<? extends FilterStrategy> clazz;

    public static FilterType findByName(String name) {
        return StreamUtils.findFirst(
                ListUtils.toList(FilterType.values()),
                (f) -> StringUtils.startWithIgnoreCase(f.name(), name)
        );
    }
}
