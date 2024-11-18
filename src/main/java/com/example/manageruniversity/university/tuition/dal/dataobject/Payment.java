package com.example.manageruniversity.university.tuition.dal.dataobject;

import com.example.manageruniversity.university.member.dal.entities.Student;
import com.example.manageruniversity.common.base.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor
public class Payment extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private Long amount;

    public Payment(Long student, Long amount) {
        this.student = new Student(student);
        this.amount = amount;
    }
}
