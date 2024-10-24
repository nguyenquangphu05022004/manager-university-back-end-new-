package com.example.manageruniversity.score;

import com.example.manageruniversity.core.schoolYear.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "score_scores")
@NoArgsConstructor
@Getter
public class Score extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_Id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;

}
