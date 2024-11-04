package com.example.manageruniversity.domain;

import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.user.domain.entity.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject_group")
@Getter
@Setter
public class SubjectGroup extends BaseEntity {
    private String groupName;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    private Integer numberOfStudent;

    @OneToMany(mappedBy = "subjectGroup")
    private List<Time> times = new ArrayList<>();

    @OneToMany(mappedBy = "subjectGroup")
    private List<Register> registers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private int numberOfStudentCurrent;

    @Override
    public boolean equals(Object o) {
        if(o instanceof SubjectGroup) {
            SubjectGroup s = (SubjectGroup) o;
            if(s.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }
}
