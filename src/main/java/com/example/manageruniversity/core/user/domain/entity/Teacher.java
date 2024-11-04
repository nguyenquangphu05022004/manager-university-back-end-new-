package com.example.manageruniversity.core.user.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "teachers")
@Getter
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {

}
