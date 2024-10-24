package com.example.manageruniversity.domain;

import com.example.manageruniversity.core.Courses;
import com.example.manageruniversity.core.schoolYear.SchoolYear;
import com.example.manageruniversity.core.schoolYear.Semester;
import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seasons")
@Getter
@Setter
@NoArgsConstructor
public class Season extends BaseEntity {
    public Season(Long id) {
        super(id);
    }

    @ManyToOne
    @JoinColumn(name = "season_semester")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "school_year_Id")
    private SchoolYear schoolYear;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    @OneToMany(mappedBy = "season")
    private List<MajorRegister> majorRegisters = new ArrayList<>();

    private boolean disabled;

    public String getFullNameSeason() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Năm học ");
        if(schoolYear != null) stringBuilder.append(schoolYear.getName());  stringBuilder.append(" ");
        if(semester != null) stringBuilder.append(semester.getSemesterName());    stringBuilder.append(" của khóa ");
        if(courses != null)  stringBuilder.append(courses.getCode());
        return stringBuilder.toString();
    }
}
