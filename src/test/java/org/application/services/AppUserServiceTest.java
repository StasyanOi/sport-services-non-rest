package org.application.services;

import org.application.models.Room;
import org.application.models.requests.RoomRequest;
import org.application.models.requests.TrainerRequest;
import org.application.models.users.AppUser;
import org.application.repositories.users.AppUserRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AppUserServiceTest {

    @Mock
    private AppUserRepo mockAppUserRepo;

    private AppUserService appUserServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        appUserServiceUnderTest = new AppUserService(mockAppUserRepo);
    }

    @Test
    public void testGetTrainers() {
        // Setup

        // Configure AppUserRepo.findAll(...).
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
        final List<AppUser> appUsers = Arrays.asList(appUser);
        when(mockAppUserRepo.findAll()).thenReturn(appUsers);

        // Run the test
        final List<AppUser> result = appUserServiceUnderTest.getTrainers();

        // Verify the results
    }

    @Test
    public void testCreateUser() {
        // Setup
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

        // Configure AppUserRepo.save(...).
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
        when(mockAppUserRepo.save(any(AppUser.class))).thenReturn(appUser1);

        // Run the test
        appUserServiceUnderTest.createUser(appUser);

        // Verify the results
    }

    @Test
    public void testGetCurrentUserInfo() {
        // Setup

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
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        roomRequest.setRoom(room);
        roomRequest.setApproved(false);
        appUser.setRoomRequests(Arrays.asList(roomRequest));
        when(mockAppUserRepo.findByUsername("username")).thenReturn(appUser);

        // Run the test
        final AppUser result = appUserServiceUnderTest.getCurrentUserInfo();

        // Verify the results
    }
}
