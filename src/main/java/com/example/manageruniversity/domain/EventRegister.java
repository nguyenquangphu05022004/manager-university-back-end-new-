package com.example.manageruniversity.domain;

import com.example.manageruniversity.share.BaseEntity;
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
public class EventRegister extends BaseEntity {
    private LocalDateTime start;
    private LocalDateTime end;
    @OneToMany(mappedBy = "eventRegister")
    private List<MajorRegister> majorRegisters = new ArrayList<>();
}
