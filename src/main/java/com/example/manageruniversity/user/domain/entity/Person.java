package com.example.manageruniversity.user.domain.entity;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.util.Date;

@MappedSuperclass
@Getter
public abstract class Person extends BaseEntity {
    @Id
    private String entityId;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private Boolean sex;
    private String avatar;
}
