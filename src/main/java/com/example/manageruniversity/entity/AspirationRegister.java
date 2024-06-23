package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.poi.ss.formula.functions.Even;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aspiration_registers")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AspirationRegister extends Base {
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    private LocalDateTime start;
    private LocalDateTime end;

    @Transient
    public boolean getOpenRegister() {
        LocalDateTime now = LocalDateTime.now();
        if (start.isAfter(now)) return false;
        else if (now.isBefore(end)) return true;
        return false;
    }
}
