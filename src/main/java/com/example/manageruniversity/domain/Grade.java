package com.example.manageruniversity.domain;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grade extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "register_id")
    private Register register;
    private float attend;
    private float midtermTest;
    private float finalTest;
    private float practiceTest;
    @ManyToOne
    @JoinColumn(name = "component_grade_id")
    private ComponentGrade componentGrade;
}
