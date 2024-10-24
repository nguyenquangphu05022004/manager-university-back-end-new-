package com.example.manageruniversity.core.major;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "majors")
@Getter
@Setter
public class Major extends BaseEntity {
    @Id
    private String majorId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_major_id")
    private Major parentMajorId;

    @OneToMany(mappedBy = "parentMajorId")
    private List<Major> subMajors;

}
