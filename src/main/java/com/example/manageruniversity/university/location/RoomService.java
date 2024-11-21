package com.example.manageruniversity.university.location;

import java.util.List;

public interface RoomService {
    Room update();
    Room getById(Long roomId);
    List<Room> getList();
}
