package com.example.manageruniversity.core.score.domain.enums;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.collection.StreamUtils;
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

    public ScoreType findByIndex(final int index) {
        return StreamUtils.findFirst(
                ListUtils.toList(ScoreType.values()),
                (scoreType -> scoreType.index == index)
        );
    }


}
