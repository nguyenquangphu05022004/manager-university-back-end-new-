package com.example.manageruniversity.core.schoolYear.domain.entity;

import com.example.manageruniversity.core.schoolYear.domain.enums.Semester;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "school_years")
@Getter
@NoArgsConstructor
public class SchoolYear extends SubBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private Integer from;
    @Setter
    private Integer to;
    @Enumerated(EnumType.STRING)
    @Setter
    private Semester semester;

    public SchoolYear(Integer from, Integer to, Semester semester) {
        this.from = from;
        this.to = to;
        this.semester = semester;
    }
}
