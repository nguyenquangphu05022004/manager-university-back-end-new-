package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
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
public class Season extends Base{
    public Season(Long id){
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

}
