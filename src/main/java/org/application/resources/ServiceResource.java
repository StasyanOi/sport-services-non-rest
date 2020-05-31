package org.application.resources;

import org.application.models.Room;
import org.application.services.AppUserService;
import org.application.services.RoomRequestService;
import org.application.services.RoomService;
import org.application.services.TrainerRequestService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/services")
public class ServiceResource {


    private TrainerRequestService trainerRequestService;

    private RoomRequestService roomRequestService;

    private RoomService roomService;

    private AppUserService appUserService;


    public ServiceResource(TrainerRequestService trainerRequestService, RoomRequestService roomRequestService, RoomService roomService, AppUserService appUserService) {
        this.trainerRequestService = trainerRequestService;
        this.roomRequestService = roomRequestService;
        this.roomService = roomService;
        this.appUserService = appUserService;
    }


    @GetMapping("/rooms")
    public ModelAndView getRooms() {
        ModelAndView modelAndView = new ModelAndView("rooms");
        modelAndView.addObject("rooms", roomService.getAllRooms());
        return modelAndView;
    }

    @GetMapping("/trainers")
    public ModelAndView getTrainers() {
        ModelAndView modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainers", appUserService.getTrainers());
        return modelAndView;
    }

    @GetMapping("/rooms/apply")
    public String signUpToRoom(@RequestParam("id") Long roomId,
                               @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime start,
                               @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime end) throws SQLException {
        roomRequestService.addRoomRequest(roomId, start, end);
        return "redirect:/services/rooms";
    }

    @GetMapping("/trainers/apply")
    public String signUpToTrainer(@RequestParam("id") Long trainerId,
                                  @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime start,
                                  @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime end) throws SQLException {
        trainerRequestService.addTrainerRequest(trainerId, start, end);
        return "redirect:/services/trainers";
    }

    @PostMapping("/rooms/create")
    public String addRoom(Room room) {
        roomService.createRoom(room);
        return "redirect:/services/rooms";
    }
}
