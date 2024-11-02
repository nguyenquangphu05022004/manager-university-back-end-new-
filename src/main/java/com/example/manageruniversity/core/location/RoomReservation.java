package com.example.manageruniversity.core.location;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "room_reservation")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class RoomReservation extends SubBaseEntity {
    private Room room;
    private LocalDate start;
    private LocalDate end;
    private LocalTime time;
    private int numberOfWeek;
}
