package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event_registers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventRegister extends Base{
    private LocalDateTime start;
    private LocalDateTime end;
    @OneToMany(mappedBy = "eventRegister")
    private List<MajorRegister> majorRegisters = new ArrayList<>();
}
