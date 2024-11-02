package com.example.manageruniversity.core.location.repo;

import com.example.manageruniversity.core.location.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
}
