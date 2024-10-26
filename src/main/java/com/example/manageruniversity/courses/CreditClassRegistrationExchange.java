package com.example.manageruniversity.courses;

import com.example.manageruniversity.courses.registration.CreditClassRegistration;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "courses_credit_class_registration_exchange")
public class CreditClassRegistrationExchange extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "creditClassRegistrationRequest_id")
    private CreditClassRegistration creditClassRegistrationRequest;

    @ManyToOne
    @JoinColumn(name = "creditClassRegistrationResponse_id")
    private CreditClassRegistration creditClassRegistrationResponse;
}
