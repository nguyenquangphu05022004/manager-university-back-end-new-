package com.example.manageruniversity.core.user.domain.entity;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Getter
@NoArgsConstructor
public abstract class Person extends BaseEntity {
    @Id
    private String personId;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private Boolean sex;
    private String avatar;

    public Person(String personId) {
        this.personId = personId;
    }

}
