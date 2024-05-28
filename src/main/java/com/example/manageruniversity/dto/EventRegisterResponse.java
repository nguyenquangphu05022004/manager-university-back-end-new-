package com.example.manageruniversity.dto;

import com.example.manageruniversity.utils.SystemUtils;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter

public class EventRegisterResponse {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<String> nameMajorRegister = new ArrayList<>();
    public String getFormatStart() {
        return start.format(SystemUtils.PATTERN_DATE_VIE);
    }
    public String getFormatEnd() {
        return end.format(SystemUtils.PATTERN_DATE_VIE);
    }
}
