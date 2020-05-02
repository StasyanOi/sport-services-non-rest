package org.application.resources;

import org.application.models.users.AppUser;
import org.application.services.AppUserService;
import org.h2.jdbc.JdbcSQLException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthResource {

    final AppUserService appUserService;


    public AuthResource(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login-error")
    public String getLoginError() {
        return "login-error";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register(AppUser appUser) {
        try {
            appUserService.createUser(appUser);

        } catch (Exception e) {
            return "forward:login-error";
        }
        return "redirect:login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }
}
