package com.example.manageruniversity.user;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
@DiscriminatorValue("STUDENT")
public class Student extends User {

}
