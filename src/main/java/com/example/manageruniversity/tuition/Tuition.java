package com.example.manageruniversity.tuition;

import com.example.manageruniversity.core.schoolYear.SchoolYear;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tuition_tuition")
@Getter
public class Tuition extends SubBaseEntity {
    private SchoolYear schoolYear;
    private Student student;
    private Long unAdjustedAmount;
    private Long discountedAmount;
    private Long amountDue;
    private Long amountReceived;
    private Long outstandingBalance;
}
