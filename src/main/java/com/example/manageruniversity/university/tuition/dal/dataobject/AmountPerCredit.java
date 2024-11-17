package com.example.manageruniversity.university.tuition.dal.dataobject;

import com.example.manageruniversity.university.course.Course;
import com.example.manageruniversity.university.major.Major;
import com.example.manageruniversity.university.school_year.SchoolYear;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tuition_amount_per_credit")
@Getter
@NoArgsConstructor
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


    public AmountPerCredit(Integer amount, Long schoolYear, String major, String course) {
        this.amount = amount;
        this.schoolYear = new SchoolYear(schoolYear);
        this.major = new Major(major);
        this.course = new Course(course);
    }
}
