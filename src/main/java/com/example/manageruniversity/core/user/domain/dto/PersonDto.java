package com.example.manageruniversity.core.user.domain.dto;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.user.domain.entity.Person;
import lombok.Data;

import java.util.Date;

@Data
public class PersonDto {
    private String entityId;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private Boolean sex;
    private String avatar;

    public PersonDto(Person person) {
        if(ObjectUtils.isNull(person)) return;
        this.entityId = person.getPersonId();
        this.fullName = person.getFullName();
        this.address = person.getAddress();
        this.phoneNumber = person.getPhoneNumber();
        this.dateOfBirth = person.getDateOfBirth();
        this.sex = person.getSex();
        this.avatar = person.getAvatar();
    }
}
