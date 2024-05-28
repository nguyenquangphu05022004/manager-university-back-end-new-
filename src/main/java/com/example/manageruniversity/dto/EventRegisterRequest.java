package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventRegisterRequest {
    private LocalDateTime start;
    private LocalDateTime end;
    private Long seasonId;
    private List<Long> majorIds;
}
