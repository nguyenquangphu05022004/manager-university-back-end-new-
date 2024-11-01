package com.example.manageruniversity.user.domain.entity;

import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.user.domain.request.PersonRequest;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Getter
public abstract class Person extends BaseEntity {
    @Id
    private String personId;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private Boolean sex;
    private String avatar;



}
