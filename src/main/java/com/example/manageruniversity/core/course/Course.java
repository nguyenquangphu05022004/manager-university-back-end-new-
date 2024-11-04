package com.example.manageruniversity.core.course;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Getter
@NoArgsConstructor
public class Course extends BaseEntity {
    @Id
    private String courseId;
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public Course(String courseId, String name) {

        this.courseId = courseId;
        this.name = name;
    }
}
