package org.application.services;

import org.application.models.Room;
import org.application.models.requests.RoomRequest;
import org.application.models.requests.TrainerRequest;
import org.application.models.users.AppUser;
import org.application.repositories.RoomRepo;
import org.application.repositories.requests.RoomRequestRepo;
import org.application.repositories.users.AppUserRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RoomRequestServiceTest {

    @Mock
    private RoomRequestRepo mockRoomRequestRepo;
    @Mock
    private AppUserRepo mockAppUserRepo;
    @Mock
    private RoomRepo mockRoomRepo;

    private RoomRequestService roomRequestServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        roomRequestServiceUnderTest = new RoomRequestService(mockRoomRequestRepo, mockAppUserRepo, mockRoomRepo);
    }

    @Test
    public void testAddRoomRequest() {
        // Setup

        // Configure RoomRepo.getOne(...).
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        when(mockRoomRepo.getOne(0L)).thenReturn(room);

        // Configure AppUserRepo.findByUsername(...).
        final AppUser appUser = new AppUser();
        appUser.setId(0L);
        appUser.setUsername("username");
        appUser.setPassword("password");
        appUser.setFirstName("firstName");
        appUser.setLastName("lastName");
        appUser.setEmail("email");
        appUser.setAuthority("authority");
        appUser.setEnabled(false);
        final TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setId(0L);
        trainerRequest.setRequester(new AppUser());
        trainerRequest.setTrainer(new AppUser());
        trainerRequest.setApproved(false);
        appUser.setTrainerRequests(Arrays.asList(trainerRequest));
        final RoomRequest roomRequest = new RoomRequest();
        roomRequest.setId(0L);
        roomRequest.setRequester(new AppUser());
        final Room room1 = new Room();
        room1.setId(0L);
        room1.setArea(0L);
        roomRequest.setRoom(room1);
        roomRequest.setApproved(false);
        appUser.setRoomRequests(Arrays.asList(roomRequest));
        when(mockAppUserRepo.findByUsername("username")).thenReturn(appUser);

        // Configure RoomRequestRepo.save(...).
        final RoomRequest roomRequest1 = new RoomRequest();
        roomRequest1.setId(0L);
        final AppUser requester = new AppUser();
        requester.setId(0L);
        requester.setUsername("username");
        requester.setPassword("password");
        requester.setFirstName("firstName");
        requester.setLastName("lastName");
        requester.setEmail("email");
        requester.setAuthority("authority");
        requester.setEnabled(false);
        final TrainerRequest trainerRequest1 = new TrainerRequest();
        trainerRequest1.setId(0L);
        trainerRequest1.setRequester(new AppUser());
        trainerRequest1.setTrainer(new AppUser());
        trainerRequest1.setApproved(false);
        requester.setTrainerRequests(Arrays.asList(trainerRequest1));
        requester.setRoomRequests(Arrays.asList(new RoomRequest()));
        roomRequest1.setRequester(requester);
        final Room room2 = new Room();
        room2.setId(0L);
        room2.setArea(0L);
        roomRequest1.setRoom(room2);
        roomRequest1.setApproved(false);
        when(mockRoomRequestRepo.save(any(RoomRequest.class))).thenReturn(roomRequest1);

        // Run the test
        roomRequestServiceUnderTest.addRoomRequest(0L);

        // Verify the results
    }

    @Test
    public void testGetAll() {
        // Setup

        // Configure RoomRequestRepo.findAll(...).
        final RoomRequest roomRequest = new RoomRequest();
        roomRequest.setId(0L);
        final AppUser requester = new AppUser();
        requester.setId(0L);
        requester.setUsername("username");
        requester.setPassword("password");
        requester.setFirstName("firstName");
        requester.setLastName("lastName");
        requester.setEmail("email");
        requester.setAuthority("authority");
        requester.setEnabled(false);
        final TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setId(0L);
        trainerRequest.setRequester(new AppUser());
        trainerRequest.setTrainer(new AppUser());
        trainerRequest.setApproved(false);
        requester.setTrainerRequests(Arrays.asList(trainerRequest));
        requester.setRoomRequests(Arrays.asList(new RoomRequest()));
        roomRequest.setRequester(requester);
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        roomRequest.setRoom(room);
        roomRequest.setApproved(false);
        final List<RoomRequest> roomRequests = Arrays.asList(roomRequest);
        when(mockRoomRequestRepo.findAll()).thenReturn(roomRequests);

        // Run the test
        final List<RoomRequest> result = roomRequestServiceUnderTest.getAll();

        // Verify the results
    }

    @Test
    public void testGetUnaprovedRequests() {
        // Setup

        // Configure RoomRequestRepo.findAll(...).
        final RoomRequest roomRequest = new RoomRequest();
        roomRequest.setId(0L);
        final AppUser requester = new AppUser();
        requester.setId(0L);
        requester.setUsername("username");
        requester.setPassword("password");
        requester.setFirstName("firstName");
        requester.setLastName("lastName");
        requester.setEmail("email");
        requester.setAuthority("authority");
        requester.setEnabled(false);
        final TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setId(0L);
        trainerRequest.setRequester(new AppUser());
        trainerRequest.setTrainer(new AppUser());
        trainerRequest.setApproved(false);
        requester.setTrainerRequests(Arrays.asList(trainerRequest));
        requester.setRoomRequests(Arrays.asList(new RoomRequest()));
        roomRequest.setRequester(requester);
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        roomRequest.setRoom(room);
        roomRequest.setApproved(false);
        final List<RoomRequest> roomRequests = Arrays.asList(roomRequest);
        when(mockRoomRequestRepo.findAll()).thenReturn(roomRequests);

        // Run the test
        final List<RoomRequest> result = roomRequestServiceUnderTest.getUnaprovedRequests();

        // Verify the results
    }

    @Test
    public void testApproveRequest() {
        // Setup

        // Configure RoomRequestRepo.getOne(...).
        final RoomRequest roomRequest = new RoomRequest();
        roomRequest.setId(0L);
        final AppUser requester = new AppUser();
        requester.setId(0L);
        requester.setUsername("username");
        requester.setPassword("password");
        requester.setFirstName("firstName");
        requester.setLastName("lastName");
        requester.setEmail("email");
        requester.setAuthority("authority");
        requester.setEnabled(false);
        final TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setId(0L);
        trainerRequest.setRequester(new AppUser());
        trainerRequest.setTrainer(new AppUser());
        trainerRequest.setApproved(false);
        requester.setTrainerRequests(Arrays.asList(trainerRequest));
        requester.setRoomRequests(Arrays.asList(new RoomRequest()));
        roomRequest.setRequester(requester);
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        roomRequest.setRoom(room);
        roomRequest.setApproved(false);
        when(mockRoomRequestRepo.getOne(0L)).thenReturn(roomRequest);

        // Run the test
        roomRequestServiceUnderTest.approveRequest(0L);

        // Verify the results
    }
}
