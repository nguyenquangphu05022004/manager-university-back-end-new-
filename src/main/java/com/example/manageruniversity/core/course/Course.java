package com.example.manageruniversity.core.course;

import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.domain.Season;
import com.example.manageruniversity.user.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
public class Course extends BaseEntity {
    @Id
    private String courseId;
    private String name;
}
