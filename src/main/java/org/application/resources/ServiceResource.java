package org.application.resources;

import org.application.services.AppUserService;
import org.application.services.RoomRequestService;
import org.application.services.RoomService;
import org.application.services.TrainerRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/services")
public class ServiceResource {


    private
    TrainerRequestService trainerRequestService;

    private
    RoomRequestService roomRequestService;

    private
    RoomService roomService;

    private
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

    @GetMapping("/rooms/apply")
    public String signUpToRoom(@RequestParam("id") Long roomId) {
        roomRequestService.addRoomRequest(roomId);
        return "redirect:/services/rooms";
    }

    @GetMapping("/trainers/apply")
    public String signUpToTrainer(@RequestParam("id") Long trainerId) {
        trainerRequestService.addTrainerRequest(trainerId);
        return "redirect:/services/trainers";
    }
}
