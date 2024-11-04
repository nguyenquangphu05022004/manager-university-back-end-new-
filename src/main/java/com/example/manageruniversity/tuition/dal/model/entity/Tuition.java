package com.example.manageruniversity.tuition.dal.model.entity;

import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.domain.entity.Student;
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
}
