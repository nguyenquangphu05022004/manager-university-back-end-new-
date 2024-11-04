package com.example.manageruniversity.core.credit_class.registration;

import com.example.manageruniversity.core.credit_class.CreditClass;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.core.user.domain.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "courses_credit_class_registration")
@Getter
public class CreditClassRegistration extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "credit_class_id")
    private CreditClass creditClass;
}
