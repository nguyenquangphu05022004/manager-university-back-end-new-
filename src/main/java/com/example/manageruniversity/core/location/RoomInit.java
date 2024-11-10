package com.example.manageruniversity.core.location;

import com.example.manageruniversity.common.collection.CollUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoomInit {
    private final RoomRepository roomRepository;

    @PostConstruct
    public void init() {
        if(CollUtils.isEmpty(roomRepository.findAll())) {
            List<Room> rooms = List.of(
                    new Room("202", House.A1),
                    new Room("203", House.A1),
                    new Room("204", House.A1),
                    new Room("205", House.A1),
                    new Room("102", House.A2),
                    new Room("202", House.A2),
                    new Room("203", House.A2),
                    new Room("204", House.A2),
                    new Room("402", House.A2),
                    new Room("302", House.A2),
                    new Room("705", House.A2),
                    new Room("204", House.A3),
                    new Room("201-B", House.A3),
                    new Room("204", House.A3),
                    new Room("506", House.A3),
                    new Room("601", House.A2),
                    new Room("602", House.A2),
                    new Room("801", House.A2),
                    new Room("805", House.A2),
                    new Room("505", House.A3)
            );
            rooms.forEach(s -> this.roomRepository.save(s));
        }
    }
}
