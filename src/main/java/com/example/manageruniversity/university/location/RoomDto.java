package com.example.manageruniversity.university.location;

import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private String name;
    private House house;
    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getCode();
        this.house = room.getHouse();
    }
}
