package org.application.resources;

import org.application.resources.ServiceResource;
import org.application.services.AppUserService;
import org.application.services.RoomRequestService;
import org.application.services.RoomService;
import org.application.services.TrainerRequestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(MockitoJUnitRunner.class)
public class ServiceResourceTest {

    @Mock
    private TrainerRequestService trainerRequestService;
    @Mock
    private RoomRequestService roomRequestService;
    @Mock
    private RoomService roomService;
    @Mock
    private AppUserService appUserService;


    @Spy
    @InjectMocks
    private ServiceResource serviceResource;

    @Test
    public void getRooms() {
        ModelAndView rooms = serviceResource.getRooms();

        Assert.assertEquals("rooms", rooms.getViewName());
        Assert.assertEquals(1, rooms.getModelMap().size());
    }

    @Test
    public void getTrainers() {
        ModelAndView trainers = serviceResource.getTrainers();

        Assert.assertEquals("trainers", trainers.getViewName());
        Assert.assertEquals(1, trainers.getModelMap().size());
    }

    @Test
    public void signUpToRoom() {
        String redirectUrl = serviceResource.signUpToRoom(1L);

        Assert.assertEquals("redirect:/services/rooms", redirectUrl);
    }

    @Test
    public void signUpToTrainer() {
        String redirectUrl = serviceResource.signUpToTrainer(1L);

        Assert.assertEquals("redirect:/services/trainers", redirectUrl);
    }
}