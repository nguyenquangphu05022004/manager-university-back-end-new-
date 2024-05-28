package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "majors")
@Getter
@Setter
public class Major extends Base{
    private String name;
    private String sub;
    @OneToMany(mappedBy = "major")
    private List<MajorRegister> majorRegisters = new ArrayList<>();

    @OneToMany(mappedBy = "major")
    private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "major")
    private List<Teacher> teachers = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Major) {
            Major major = (Major) obj;
            if(major.getId() == this.getId() || major.getSub().equals(this.sub)) {
                return true;
            }
        }
        return false;
    }
}
