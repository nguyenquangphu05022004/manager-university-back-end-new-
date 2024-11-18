package com.example.manageruniversity.university.location;

import com.example.manageruniversity.common.base.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "location_room_reservation")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class RoomReservation extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private LocalDate start;
    private LocalDate end;
    private LocalTime time;
    private int numberOfWeek;
}
