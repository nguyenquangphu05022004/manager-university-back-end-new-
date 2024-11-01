package com.example.manageruniversity.user.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "teachers")
@Getter
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {

}
