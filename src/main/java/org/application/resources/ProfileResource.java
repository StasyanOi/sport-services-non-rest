package org.application.resources;

import org.application.models.users.AppUser;
import org.application.services.AppUserService;
import org.application.services.RoomRequestService;
import org.application.services.TrainerRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class ProfileResource {

    final AppUserService appUserService;

    final
    RoomRequestService roomRequestService;

    final
    TrainerRequestService trainerRequestService;

    public ProfileResource(AppUserService appUserService, RoomRequestService roomRequestService, TrainerRequestService trainerRequestService) {
        this.appUserService = appUserService;
        this.roomRequestService = roomRequestService;
        this.trainerRequestService = trainerRequestService;
    }


    @GetMapping("/primary")
    public ModelAndView getProfile() {
        ModelAndView modelAndView = new ModelAndView("profile");
        AppUser appUser = appUserService.getCurrentUserInfo();
        modelAndView.addObject("appUser", appUser);
        modelAndView.addObject("room_req", roomRequestService.getAll());
        modelAndView.addObject("trainer_req", trainerRequestService.getAll());
        modelAndView.addObject("current_trainers_requests", trainerRequestService.getRequestsForTrainer(appUser));
        return modelAndView;
    }
}
