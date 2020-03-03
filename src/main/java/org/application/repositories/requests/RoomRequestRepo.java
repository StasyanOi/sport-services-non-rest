package org.application.repositories.requests;

import org.application.models.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRequestRepo extends JpaRepository<Room,Long> {
}
