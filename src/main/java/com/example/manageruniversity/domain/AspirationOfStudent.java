package com.example.manageruniversity.domain;

import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.user.domain.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aspiration_of_students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AspirationOfStudent extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "aspiration_registers")
    private AspirationRegister aspirationRegister;
    private boolean approval;
}
