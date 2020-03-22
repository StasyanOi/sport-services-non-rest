package org.application.resources;

import org.application.models.Room;
import org.application.models.requests.RoomRequest;
import org.application.models.requests.TrainerRequest;
import org.application.models.users.AppUser;
import org.application.services.AppUserService;
import org.application.services.RoomRequestService;
import org.application.services.RoomService;
import org.application.services.TrainerRequestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ServiceResourceTest {

    @Mock
    private TrainerRequestService mockTrainerRequestService;
    @Mock
    private RoomRequestService mockRoomRequestService;
    @Mock
    private RoomService mockRoomService;
    @Mock
    private AppUserService mockAppUserService;

    private ServiceResource serviceResourceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        serviceResourceUnderTest = new ServiceResource(mockTrainerRequestService, mockRoomRequestService, mockRoomService, mockAppUserService);
    }

    @Test
    public void testGetRooms() {
        // Setup

        // Configure RoomService.getAllRooms(...).
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        final List<Room> rooms = Arrays.asList(room);
        when(mockRoomService.getAllRooms()).thenReturn(rooms);

        // Run the test
        final ModelAndView result = serviceResourceUnderTest.getRooms();

        // Verify the results
    }

    @Test
    public void testGetTrainers() {
        // Setup

        // Configure AppUserService.getTrainers(...).
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
        when(mockAppUserService.getTrainers()).thenReturn(appUsers);

        // Run the test
        final ModelAndView result = serviceResourceUnderTest.getTrainers();

        // Verify the results
    }

    @Test
    public void testSignUpToRoom() {
        // Setup

        // Configure RoomService.getAllRooms(...).
        final Room room = new Room();
        room.setId(0L);
        room.setArea(0L);
        final List<Room> rooms = Arrays.asList(room);
        when(mockRoomService.getAllRooms()).thenReturn(rooms);

        // Run the test
        final ModelAndView result = serviceResourceUnderTest.signUpToRoom(0L);

        // Verify the results
        verify(mockRoomRequestService).addRoomRequest(0L);
    }

    @Test
    public void testSignUpToTrainer() {
        // Setup

        // Configure AppUserService.getTrainers(...).
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
        when(mockAppUserService.getTrainers()).thenReturn(appUsers);

        // Run the test
        final ModelAndView result = serviceResourceUnderTest.signUpToTrainer(0L);

        // Verify the results
        verify(mockTrainerRequestService).addTrainerRequest(0L);
    }
}
