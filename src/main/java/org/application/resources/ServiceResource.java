package org.application.resources;

import org.application.services.AppUserService;
import org.application.services.RoomRequestService;
import org.application.services.RoomService;
import org.application.services.TrainerRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/services")
public class ServiceResource {


    final
    TrainerRequestService trainerRequestService;

    final
    RoomRequestService roomRequestService;

    final
    RoomService roomService;

    final
    AppUserService appUserService;


    public ServiceResource(TrainerRequestService trainerRequestService, RoomRequestService roomRequestService, RoomService roomService, AppUserService appUserService) {
        this.trainerRequestService = trainerRequestService;
        this.roomRequestService = roomRequestService;
        this.roomService = roomService;
        this.appUserService = appUserService;
    }


    @GetMapping("/rooms")
    public ModelAndView getRooms() {
        ModelAndView modelAndView = new ModelAndView("rooms");
        modelAndView.addObject("rooms",roomService.getAllRooms());
        return modelAndView;
    }

    @GetMapping("/trainers")
    public ModelAndView getTrainers() {
        ModelAndView modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainers",appUserService.getTrainers());
        return modelAndView;
    }
}
