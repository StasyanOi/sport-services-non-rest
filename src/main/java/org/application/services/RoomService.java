package org.application.services;

import org.application.models.Room;
import org.application.repositories.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    final
    RoomRepo roomRepo;

    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }
}
