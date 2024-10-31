package com.example.manageruniversity.domain;

import com.example.manageruniversity.core.major.domain.entity.Major;
import com.example.manageruniversity.core.subject.domain.entity.Subject;
import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "majorRegisters")
@Getter
@Setter
public class MajorRegister extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @OneToMany(mappedBy = "majorRegister")
    private List<Register> registers = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "majorRegister_Subject",joinColumns = @JoinColumn(name = "majorRegister_id"),
    inverseJoinColumns = @JoinColumn(name = "subjectId"))
    private List<Subject> subjects = new ArrayList<>();

    @OneToOne(mappedBy = "majorRegister")
    private Tuition tuition;

    @ManyToOne
    @JoinColumn(name = "event_register_id")
    //openRegister
    private EventRegister eventRegister;

    @Transient
    public boolean getOpenRegister() {
        if(eventRegister != null) {
            if(eventRegister.getStart().isAfter(LocalDateTime.now())) return false;
            else if(LocalDateTime.now().isBefore(eventRegister.getEnd())) return true;
            return false;
        }
        return false;
    }


}
