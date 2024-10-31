package com.example.manageruniversity.user.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "teachers")
@Getter
public class Teacher extends Person {

}
