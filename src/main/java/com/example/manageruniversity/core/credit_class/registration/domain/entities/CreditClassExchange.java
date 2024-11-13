package com.example.manageruniversity.core.credit_class.registration.domain.entities;

import com.example.manageruniversity.core.credit_class.self.CreditClass;
import com.example.manageruniversity.core.member.dal.entities.Student;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "courses_credit_class_registration_exchange")
@NoArgsConstructor
public class CreditClassExchange extends SubBaseEntity {


    @ManyToOne
    @JoinColumn(name = "from_student_id")
    private Student fromStudent;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private CreditClass request;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private CreditClass target;

    @ManyToOne
    @JoinColumn(name = "to_student_id")
    private Student toStudent;

    public CreditClassExchange(
            Long fromStudentId,
            Long requestId,
            Long targetId,
            Long targetStudentId
    ) {
        this.fromStudent = new Student(fromStudentId);
        this.request = new CreditClass(requestId);
        this.target = new CreditClass(targetId);
        this.toStudent = new Student(targetStudentId);
    }

}
