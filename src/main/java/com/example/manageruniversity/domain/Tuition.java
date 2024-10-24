package com.example.manageruniversity.domain;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "tuition")
@Data
@Getter
public class Tuition extends BaseEntity {
    private Integer moneyPerCredit;
    @OneToOne
    @JoinColumn(name = "major_register_id")
    private MajorRegister majorRegister;
}
