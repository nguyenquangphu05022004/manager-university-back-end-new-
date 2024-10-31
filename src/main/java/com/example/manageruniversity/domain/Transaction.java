package com.example.manageruniversity.domain;

import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.user.domain.entity.Student;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register targetRegister;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;




}
