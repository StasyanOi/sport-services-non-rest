package org.application.services;

import org.application.models.Room;
import org.application.repositories.RoomRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RoomServiceTest {

    @Mock
    private RoomRepo mockRoomRepo;

    private RoomService roomServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        roomServiceUnderTest = new RoomService(mockRoomRepo);
    }

    @Test
    public void testGetAllRooms() {
        // Setup

        // Configure RoomRepo.findAll(...).
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        final List<Room> rooms = Arrays.asList(room);
        when(mockRoomRepo.findAll()).thenReturn(rooms);

        // Run the test
        final List<Room> result = roomServiceUnderTest.getAllRooms();

        // Verify the results
    }
}
