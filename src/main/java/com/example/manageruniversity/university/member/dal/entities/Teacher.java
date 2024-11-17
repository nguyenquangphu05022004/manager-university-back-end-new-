package com.example.manageruniversity.university.member.dal.entities;

import com.example.manageruniversity.university.member.domain.enums.MemberType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "teachers")
@Getter
@DiscriminatorValue("TEACHER")
@NoArgsConstructor
public class Teacher extends User {
    public Teacher(Long teacherId) {
        super(teacherId);
    }

    public Teacher(String username, String password, MemberType memberType, String email, String fullName, String address, String phoneNumber, Date dateOfBirth, Boolean sex) {
        super(username, password, memberType, email, fullName, address, phoneNumber, dateOfBirth, sex);
    }
}
