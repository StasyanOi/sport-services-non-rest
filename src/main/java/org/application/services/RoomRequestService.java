package org.application.services;

import org.application.repositories.requests.RoomRequestRepo;
import org.springframework.stereotype.Service;

@Service
public class RoomRequestService {

    final
    RoomRequestRepo roomRequestRepo;

    public RoomRequestService(RoomRequestRepo roomRequestRepo) {
        this.roomRequestRepo = roomRequestRepo;
    }
}
