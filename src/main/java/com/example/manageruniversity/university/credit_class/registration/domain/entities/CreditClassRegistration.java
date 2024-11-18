package com.example.manageruniversity.university.credit_class.registration.domain.entities;

import com.example.manageruniversity.university.credit_class.self.CreditClass;
import com.example.manageruniversity.university.member.dal.entities.Student;
import com.example.manageruniversity.university.school_year.SchoolYear;
import com.example.manageruniversity.common.base.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses_credit_class_registration")
@Getter
@NoArgsConstructor
public class CreditClassRegistration extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    @Setter
    private Student student;

    @ManyToOne
    @JoinColumn(name = "credit_class_id")
    private CreditClass creditClass;


    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;

    @Enumerated(EnumType.STRING)
    @Setter
    private Status status;

    public static enum Status {
        PENDING,
        ACCEPT;
    }

    public CreditClassRegistration(Student student, SchoolYear schoolYear, CreditClass creditClass) {
        this.student = student;
        this.creditClass = creditClass;
        this.status = Status.PENDING;
        this.schoolYear = schoolYear;
    }

}
