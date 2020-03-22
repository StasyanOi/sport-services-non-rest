package org.application.services;

import org.application.models.Room;
import org.application.models.requests.RoomRequest;
import org.application.models.requests.TrainerRequest;
import org.application.models.users.AppUser;
import org.application.repositories.requests.TrainerRequestRepo;
import org.application.repositories.users.AppUserRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TrainerRequestServiceTest {

    @Mock
    private TrainerRequestRepo mockTrainerRequestRepo;
    @Mock
    private AppUserRepo mockAppUserRepo;

    private TrainerRequestService trainerRequestServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        trainerRequestServiceUnderTest = new TrainerRequestService(mockTrainerRequestRepo, mockAppUserRepo);
    }

    @Test
    public void testAddTrainerRequest() {
        // Setup

        // Configure AppUserRepo.getOne(...).
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
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        roomRequest.setRoom(room);
        roomRequest.setApproved(false);
        appUser.setRoomRequests(Arrays.asList(roomRequest));
        when(mockAppUserRepo.getOne(0L)).thenReturn(appUser);

        // Configure AppUserRepo.findByUsername(...).
        final AppUser appUser1 = new AppUser();
        appUser1.setId(0L);
        appUser1.setUsername("username");
        appUser1.setPassword("password");
        appUser1.setFirstName("firstName");
        appUser1.setLastName("lastName");
        appUser1.setEmail("email");
        appUser1.setAuthority("authority");
        appUser1.setEnabled(false);
        final TrainerRequest trainerRequest1 = new TrainerRequest();
        trainerRequest1.setId(0L);
        trainerRequest1.setRequester(new AppUser());
        trainerRequest1.setTrainer(new AppUser());
        trainerRequest1.setApproved(false);
        appUser1.setTrainerRequests(Arrays.asList(trainerRequest1));
        final RoomRequest roomRequest1 = new RoomRequest();
        roomRequest1.setId(0L);
        roomRequest1.setRequester(new AppUser());
        final Room room1 = new Room();
        room1.setId(0L);
        room1.setArea(0L);
        roomRequest1.setRoom(room1);
        roomRequest1.setApproved(false);
        appUser1.setRoomRequests(Arrays.asList(roomRequest1));
        when(mockAppUserRepo.findByUsername("username")).thenReturn(appUser1);

        // Configure TrainerRequestRepo.save(...).
        final TrainerRequest trainerRequest2 = new TrainerRequest();
        trainerRequest2.setId(0L);
        final AppUser requester = new AppUser();
        requester.setId(0L);
        requester.setUsername("username");
        requester.setPassword("password");
        requester.setFirstName("firstName");
        requester.setLastName("lastName");
        requester.setEmail("email");
        requester.setAuthority("authority");
        requester.setEnabled(false);
        requester.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest2 = new RoomRequest();
        roomRequest2.setId(0L);
        roomRequest2.setRequester(new AppUser());
        final Room room2 = new Room();
        room2.setId(0L);
        room2.setArea(0L);
        roomRequest2.setRoom(room2);
        roomRequest2.setApproved(false);
        requester.setRoomRequests(Arrays.asList(roomRequest2));
        trainerRequest2.setRequester(requester);
        final AppUser trainer = new AppUser();
        trainer.setId(0L);
        trainer.setUsername("username");
        trainer.setPassword("password");
        trainer.setFirstName("firstName");
        trainer.setLastName("lastName");
        trainer.setEmail("email");
        trainer.setAuthority("authority");
        trainer.setEnabled(false);
        trainer.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest3 = new RoomRequest();
        roomRequest3.setId(0L);
        roomRequest3.setRequester(new AppUser());
        final Room room3 = new Room();
        room3.setId(0L);
        room3.setArea(0L);
        roomRequest3.setRoom(room3);
        roomRequest3.setApproved(false);
        trainer.setRoomRequests(Arrays.asList(roomRequest3));
        trainerRequest2.setTrainer(trainer);
        trainerRequest2.setApproved(false);
        when(mockTrainerRequestRepo.save(any(TrainerRequest.class))).thenReturn(trainerRequest2);

        // Run the test
        trainerRequestServiceUnderTest.addTrainerRequest(0L);

        // Verify the results
    }

    @Test
    public void testGetAll() {
        // Setup

        // Configure TrainerRequestRepo.findAll(...).
        final TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setId(0L);
        final AppUser requester = new AppUser();
        requester.setId(0L);
        requester.setUsername("username");
        requester.setPassword("password");
        requester.setFirstName("firstName");
        requester.setLastName("lastName");
        requester.setEmail("email");
        requester.setAuthority("authority");
        requester.setEnabled(false);
        requester.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest = new RoomRequest();
        roomRequest.setId(0L);
        roomRequest.setRequester(new AppUser());
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        roomRequest.setRoom(room);
        roomRequest.setApproved(false);
        requester.setRoomRequests(Arrays.asList(roomRequest));
        trainerRequest.setRequester(requester);
        final AppUser trainer = new AppUser();
        trainer.setId(0L);
        trainer.setUsername("username");
        trainer.setPassword("password");
        trainer.setFirstName("firstName");
        trainer.setLastName("lastName");
        trainer.setEmail("email");
        trainer.setAuthority("authority");
        trainer.setEnabled(false);
        trainer.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest1 = new RoomRequest();
        roomRequest1.setId(0L);
        roomRequest1.setRequester(new AppUser());
        final Room room1 = new Room();
        room1.setId(0L);
        room1.setArea(0L);
        roomRequest1.setRoom(room1);
        roomRequest1.setApproved(false);
        trainer.setRoomRequests(Arrays.asList(roomRequest1));
        trainerRequest.setTrainer(trainer);
        trainerRequest.setApproved(false);
        final List<TrainerRequest> trainerRequests = Arrays.asList(trainerRequest);
        when(mockTrainerRequestRepo.findAll()).thenReturn(trainerRequests);

        // Run the test
        final List<TrainerRequest> result = trainerRequestServiceUnderTest.getAll();

        // Verify the results
    }

    @Test
    public void testGetRequestsForTrainer() {
        // Setup
        final AppUser trainer = new AppUser();
        trainer.setId(0L);
        trainer.setUsername("username");
        trainer.setPassword("password");
        trainer.setFirstName("firstName");
        trainer.setLastName("lastName");
        trainer.setEmail("email");
        trainer.setAuthority("authority");
        trainer.setEnabled(false);
        final TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setId(0L);
        trainerRequest.setRequester(new AppUser());
        trainerRequest.setTrainer(new AppUser());
        trainerRequest.setApproved(false);
        trainer.setTrainerRequests(Arrays.asList(trainerRequest));
        final RoomRequest roomRequest = new RoomRequest();
        roomRequest.setId(0L);
        roomRequest.setRequester(new AppUser());
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        roomRequest.setRoom(room);
        roomRequest.setApproved(false);
        trainer.setRoomRequests(Arrays.asList(roomRequest));

        // Configure TrainerRequestRepo.findByTrainer(...).
        final TrainerRequest trainerRequest1 = new TrainerRequest();
        trainerRequest1.setId(0L);
        final AppUser requester = new AppUser();
        requester.setId(0L);
        requester.setUsername("username");
        requester.setPassword("password");
        requester.setFirstName("firstName");
        requester.setLastName("lastName");
        requester.setEmail("email");
        requester.setAuthority("authority");
        requester.setEnabled(false);
        requester.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest1 = new RoomRequest();
        roomRequest1.setId(0L);
        roomRequest1.setRequester(new AppUser());
        final Room room1 = new Room();
        room1.setId(0L);
        room1.setArea(0L);
        roomRequest1.setRoom(room1);
        roomRequest1.setApproved(false);
        requester.setRoomRequests(Arrays.asList(roomRequest1));
        trainerRequest1.setRequester(requester);
        final AppUser trainer1 = new AppUser();
        trainer1.setId(0L);
        trainer1.setUsername("username");
        trainer1.setPassword("password");
        trainer1.setFirstName("firstName");
        trainer1.setLastName("lastName");
        trainer1.setEmail("email");
        trainer1.setAuthority("authority");
        trainer1.setEnabled(false);
        trainer1.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest2 = new RoomRequest();
        roomRequest2.setId(0L);
        roomRequest2.setRequester(new AppUser());
        final Room room2 = new Room();
        room2.setId(0L);
        room2.setArea(0L);
        roomRequest2.setRoom(room2);
        roomRequest2.setApproved(false);
        trainer1.setRoomRequests(Arrays.asList(roomRequest2));
        trainerRequest1.setTrainer(trainer1);
        trainerRequest1.setApproved(false);
        final List<TrainerRequest> trainerRequests = Arrays.asList(trainerRequest1);
        when(mockTrainerRequestRepo.findByTrainer(any(AppUser.class))).thenReturn(trainerRequests);

        // Run the test
        final List<TrainerRequest> result = trainerRequestServiceUnderTest.getRequestsForTrainer(trainer);

        // Verify the results
    }

    @Test
    public void testApproveRequest() {
        // Setup

        // Configure TrainerRequestRepo.getOne(...).
        final TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setId(0L);
        final AppUser requester = new AppUser();
        requester.setId(0L);
        requester.setUsername("username");
        requester.setPassword("password");
        requester.setFirstName("firstName");
        requester.setLastName("lastName");
        requester.setEmail("email");
        requester.setAuthority("authority");
        requester.setEnabled(false);
        requester.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest = new RoomRequest();
        roomRequest.setId(0L);
        roomRequest.setRequester(new AppUser());
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        roomRequest.setRoom(room);
        roomRequest.setApproved(false);
        requester.setRoomRequests(Arrays.asList(roomRequest));
        trainerRequest.setRequester(requester);
        final AppUser trainer = new AppUser();
        trainer.setId(0L);
        trainer.setUsername("username");
        trainer.setPassword("password");
        trainer.setFirstName("firstName");
        trainer.setLastName("lastName");
        trainer.setEmail("email");
        trainer.setAuthority("authority");
        trainer.setEnabled(false);
        trainer.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest1 = new RoomRequest();
        roomRequest1.setId(0L);
        roomRequest1.setRequester(new AppUser());
        final Room room1 = new Room();
        room1.setId(0L);
        room1.setArea(0L);
        roomRequest1.setRoom(room1);
        roomRequest1.setApproved(false);
        trainer.setRoomRequests(Arrays.asList(roomRequest1));
        trainerRequest.setTrainer(trainer);
        trainerRequest.setApproved(false);
        when(mockTrainerRequestRepo.getOne(0L)).thenReturn(trainerRequest);

        // Run the test
        trainerRequestServiceUnderTest.approveRequest(0L);

        // Verify the results
    }
}
