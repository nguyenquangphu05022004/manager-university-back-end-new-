package com.example.manageruniversity.university.location;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "location_room")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Room extends SubBaseEntity {
    private String code;
    @Enumerated(EnumType.STRING)
    private House house;
}
