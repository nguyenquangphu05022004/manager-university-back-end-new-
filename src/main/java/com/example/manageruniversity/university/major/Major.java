package com.example.manageruniversity.university.major;

import com.example.manageruniversity.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "majors")
@Getter
@Setter
@NoArgsConstructor
public class Major extends BaseEntity {
    @Id
    private String majorId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_major_id")
    private Major parentMajorId;

    @OneToMany(mappedBy = "parentMajorId")
    private List<Major> subMajors;

    public Major(String majorId) {
        this.majorId = majorId;
    }

    public Major(String majorId, String name) {
        this.majorId = majorId;
        this.name = name;
    }

}
