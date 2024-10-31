package com.example.manageruniversity.user.domain.request;

import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private Boolean sex;
}
