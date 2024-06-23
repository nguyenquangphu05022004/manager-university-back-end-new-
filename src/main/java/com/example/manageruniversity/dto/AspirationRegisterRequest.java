package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AspirationRegisterRequest {
    private Long id;
    private Long seasonId;
    private LocalDateTime start;
    private LocalDateTime end;
}
