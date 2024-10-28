package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects")
@NoArgsConstructor
@Getter
public class Subject extends BaseEntity {
    @Id
    private String subjectId;
    private String subjectName;
    private Short credit;
}
