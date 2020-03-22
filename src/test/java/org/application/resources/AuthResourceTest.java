package org.application.resources;

import org.application.models.Room;
import org.application.models.requests.RoomRequest;
import org.application.models.requests.TrainerRequest;
import org.application.models.users.AppUser;
import org.application.services.AppUserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AuthResourceTest {

    @Mock
    private AppUserService mockAppUserService;

    private AuthResource authResourceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        authResourceUnderTest = new AuthResource(mockAppUserService);
    }

    @Test
    public void testGetLogin() {
        // Setup

        // Run the test
        final String result = authResourceUnderTest.getLogin();

        // Verify the results
        assertEquals("result", result);
    }

    @Test
    public void testGetLoginError() {
        // Setup

        // Run the test
        final String result = authResourceUnderTest.getLoginError();

        // Verify the results
        assertEquals("result", result);
    }

    @Test
    public void testRegister() {
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

        // Run the test
        final String result = authResourceUnderTest.register(appUser);

        // Verify the results
        assertEquals("result", result);
        verify(mockAppUserService).createUser(any(AppUser.class));
    }

    @Test
    public void testRegisterForm() {
        // Setup

        // Run the test
        final String result = authResourceUnderTest.registerForm();

        // Verify the results
        assertEquals("result", result);
    }
}
