package org.application.resources;

import org.application.models.Room;
import org.application.models.requests.RoomRequest;
import org.application.models.requests.TrainerRequest;
import org.application.models.users.AppUser;
import org.application.services.AppUserService;
import org.application.services.RoomRequestService;
import org.application.services.TrainerRequestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProfileResourceTest {

    @Mock
    private AppUserService mockAppUserService;
    @Mock
    private RoomRequestService mockRoomRequestService;
    @Mock
    private TrainerRequestService mockTrainerRequestService;

    private ProfileResource profileResourceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        profileResourceUnderTest = new ProfileResource(mockAppUserService, mockRoomRequestService, mockTrainerRequestService);
    }

    @Test
    public void testApproveRoomRequest() {
        // Setup
        final HttpServletResponse httpServletResponse = null;

        // Run the test
        final String result = profileResourceUnderTest.approveRoomRequest(0L, httpServletResponse);

        // Verify the results
        assertEquals("result", result);
        verify(mockRoomRequestService).approveRequest(0L);
    }

    @Test
    public void testApproveTrainerRequest() {
        // Setup
        final HttpServletResponse httpServletResponse = null;

        // Run the test
        final String result = profileResourceUnderTest.approveTrainerRequest(0L, httpServletResponse);

        // Verify the results
        assertEquals("result", result);
        verify(mockTrainerRequestService).approveRequest(0L);
    }

    @Test
    public void testGetProfile() {
        // Setup

        // Configure AppUserService.getCurrentUserInfo(...).
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
        when(mockAppUserService.getCurrentUserInfo()).thenReturn(appUser);

        // Configure RoomRequestService.getUnaprovedRequests(...).
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
        final Room room1 = new Room();
        room1.setId(0L);
        room1.setArea(0L);
        roomRequest1.setRoom(room1);
        roomRequest1.setApproved(false);
        final List<RoomRequest> roomRequests = Arrays.asList(roomRequest1);
        when(mockRoomRequestService.getUnaprovedRequests()).thenReturn(roomRequests);

        // Configure TrainerRequestService.getRequestsForTrainer(...).
        final TrainerRequest trainerRequest2 = new TrainerRequest();
        trainerRequest2.setId(0L);
        final AppUser requester1 = new AppUser();
        requester1.setId(0L);
        requester1.setUsername("username");
        requester1.setPassword("password");
        requester1.setFirstName("firstName");
        requester1.setLastName("lastName");
        requester1.setEmail("email");
        requester1.setAuthority("authority");
        requester1.setEnabled(false);
        requester1.setTrainerRequests(Arrays.asList(new TrainerRequest()));
        final RoomRequest roomRequest2 = new RoomRequest();
        roomRequest2.setId(0L);
        roomRequest2.setRequester(new AppUser());
        final Room room2 = new Room();
        room2.setId(0L);
        room2.setArea(0L);
        roomRequest2.setRoom(room2);
        roomRequest2.setApproved(false);
        requester1.setRoomRequests(Arrays.asList(roomRequest2));
        trainerRequest2.setRequester(requester1);
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
        final List<TrainerRequest> trainerRequests = Arrays.asList(trainerRequest2);
        when(mockTrainerRequestService.getRequestsForTrainer(any(AppUser.class))).thenReturn(trainerRequests);

        // Run the test
        final ModelAndView result = profileResourceUnderTest.getProfile();

        // Verify the results
    }
}
