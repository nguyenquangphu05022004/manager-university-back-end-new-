package com.example.manageruniversity.core.location;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "location_room")
public class Room extends SubBaseEntity {
    private String name;
    private House house;
}
