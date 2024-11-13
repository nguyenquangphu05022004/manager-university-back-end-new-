package com.example.manageruniversity.core.credit_class.self;

import com.example.manageruniversity.common.exception.ExceededException;
import com.example.manageruniversity.core.credit_class.time_table.TimeTable;
import com.example.manageruniversity.core.member.dal.entities.Student;
import com.example.manageruniversity.core.member.dal.entities.Teacher;
import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses_credit_class")
@Getter
@NoArgsConstructor
public class CreditClass extends SubBaseEntity {
    private Integer maxStudent;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;

    private Integer studyGroup;


    @ManyToMany
    @JoinTable(name = "participations",
            joinColumns = @JoinColumn(name = "credit_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;

    public CreditClass(Long id) {
        setId(id);
    }

    public CreditClass(Integer maxStudent, Teacher teacher,
                       Subject subject, SchoolYear schoolYear,
                       Integer studyGroup) {
        this.maxStudent = maxStudent;
        this.teacher = teacher;
        this.subject = subject;
        this.schoolYear = schoolYear;
        this.studyGroup = studyGroup;
    }

    @OneToMany(mappedBy = "creditClass")
    private Set<TimeTable> timeTables;


    public void addStudent(Student student) {
        if(this.students == null) {
            this.students = new HashSet<>();
        }
        if(this.students.size() <= maxStudent) {
            this.students.add(student);
        }
        throw new ExceededException("Class have been full, you can't register");
    }
}
