package com.example.manageruniversity.core.school_year;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "school_years")
@Getter
@NoArgsConstructor
@Setter
@EqualsAndHashCode(callSuper = true)
public class SchoolYear extends SubBaseEntity {

    private Integer fromYear;
    private Integer toYear;
    @Enumerated(EnumType.STRING)
    private Semester semester;


    public SchoolYear(Long id) {
        setId(id);
    }
    public SchoolYear(Integer fromYear, Integer toYear, Semester semester) {
        this.fromYear = fromYear;
        this.toYear = toYear;
        this.semester = semester;
    }



}
