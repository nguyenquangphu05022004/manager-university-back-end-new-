package com.example.manageruniversity.core.schoolYear;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "school_years")
@Getter
@Data
public class SchoolYear extends SubBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer from;
    private Integer to;
    @Enumerated(EnumType.STRING)
    private Semester semester;
}
