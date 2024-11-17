package com.example.manageruniversity.university.location;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;
    @Override
    public Room update() {
        return null;
    }

    @Override
    public Room getById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourcesNotFoundException("room not found"));
    }
}
