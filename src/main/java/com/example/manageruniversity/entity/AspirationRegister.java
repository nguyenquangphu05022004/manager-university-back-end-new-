package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @OneToMany(mappedBy = "aspirationRegister")
    private List<AspirationOfStudent> aspirationOfStudents = new ArrayList<>();

    @Transient
    public boolean getOpenRegister() {
        LocalDateTime now = LocalDateTime.now();
        if (start.isAfter(now)) return false;
        else if (now.isBefore(end)) return true;
        return false;
    }

    public Map<Subject, Boolean> getListSubject() {
        if (aspirationOfStudents.size() <= 0) return null;
        Map<Subject, Boolean> map = new HashMap<>();
        aspirationOfStudents.stream()
                .forEach(as -> {
                    map.put(
                            as.getSubject(),
                            as.isApproval()
                                    &&
                            map.getOrDefault(
                                    as.getSubject(),
                                    true
                            ));
                });
        return map;
    }
}
