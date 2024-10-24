package com.example.manageruniversity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@DiscriminatorValue("TEACHER")
public class Teacher extends User {

}
