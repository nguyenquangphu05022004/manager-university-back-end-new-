package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class Subject extends BaseEntity {
    @Id
    private String subjectId;
    private String subjectName;
    private Integer credit;

    public Subject(String subjectId) {
        this.subjectId = subjectId;
    }
}
