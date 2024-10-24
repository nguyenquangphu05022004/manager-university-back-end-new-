package com.example.manageruniversity.courses;

import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.Teacher;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "courses_credit_class")
@Getter
public class CreditClass extends SubBaseEntity {
    private Short maxStudent;
    private Teacher teacher;
    private Subject subject;
    private Integer group;
}
