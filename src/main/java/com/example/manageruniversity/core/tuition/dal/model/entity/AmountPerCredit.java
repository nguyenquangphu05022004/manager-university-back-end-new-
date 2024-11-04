package com.example.manageruniversity.core.tuition.dal.model.entity;

import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.major.Major;
import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tuition_amount_per_credit")
@Getter
public class AmountPerCredit extends SubBaseEntity {
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
