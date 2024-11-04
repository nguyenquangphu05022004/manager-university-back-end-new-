package com.example.manageruniversity.core.credit_class;

import com.example.manageruniversity.core.credit_class.time_table.TimeTable;
import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.core.user.domain.entity.Teacher;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity
@Table(name = "courses_credit_class")
@Getter
public class CreditClass extends SubBaseEntity {
    private Integer maxStudent;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;

    private Integer studyGroup;

    @OneToMany(mappedBy = "creditClass")
    private Set<TimeTable> timeTables;
}
