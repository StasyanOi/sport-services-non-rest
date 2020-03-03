package org.application.resources;

import org.application.services.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class ProfileResource {

    final AppUserService appUserService;


    public ProfileResource(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @GetMapping("/primary")
    public ModelAndView getProfile() {
        ModelAndView modelAndView = new ModelAndView("profile");
        return modelAndView;
    }
}
