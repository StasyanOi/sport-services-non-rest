package org.application.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/services")
public class ServiceResource {

    @GetMapping("/rooms")
    public ModelAndView getRooms() {
        ModelAndView modelAndView = new ModelAndView("rooms");
        return modelAndView;
    }

    @GetMapping("/trainers")
    public ModelAndView getTrainers() {
        ModelAndView modelAndView = new ModelAndView("trainers");
        return modelAndView;
    }
}
