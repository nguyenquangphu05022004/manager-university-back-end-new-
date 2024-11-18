package com.example.manageruniversity.university.tuition.dal.dataobject;

import com.example.manageruniversity.university.member.dal.entities.Student;
import com.example.manageruniversity.university.school_year.SchoolYear;
import com.example.manageruniversity.common.base.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tuition_tuition")
@Getter
public class Tuition extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private Long unAdjustedAmount;
    private Long discountedAmount;
    private Long amountDue;
    private Long amountReceived;
    private Long outstandingBalance;


    public Tuition(Long schoolYearId,
                   Long studentId,
                   Long unAdjustedAmount,
                   Long discountedAmount,
                   Long amountDue,
                   Long amountReceived,
                   Long outstandingBalance) {
        this.schoolYear = schoolYear;
        this.student = student;
        this.unAdjustedAmount = unAdjustedAmount;
        this.discountedAmount = discountedAmount;
        this.amountDue = amountDue;
        this.amountReceived = amountReceived;
        this.outstandingBalance = outstandingBalance;
    }
}
