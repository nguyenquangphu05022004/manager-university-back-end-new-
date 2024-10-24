package com.example.manageruniversity.domain;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "component_grades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComponentGrade extends BaseEntity {
    private int attend;
    private int midtermTest;
    private int finalTest;
    private int practiceTest;
    @OneToMany(mappedBy = "componentGrade")
    private List<Grade> grades = new ArrayList<>();
}
