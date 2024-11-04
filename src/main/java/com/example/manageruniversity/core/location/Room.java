package com.example.manageruniversity.core.location;

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
    private String name;
    @Enumerated(EnumType.STRING)
    private House house;
}
