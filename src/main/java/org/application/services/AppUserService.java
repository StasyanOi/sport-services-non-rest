package org.application.services;

import org.application.models.users.AppUser;
import org.application.repositories.users.AppUserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AppUserService {

    final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public List<AppUser> getTrainers() {
        List<AppUser> all = appUserRepo.findAll();

        return all.stream()
                .filter(appUser -> appUser.getAuthority().equals("ROLE_TRAINER"))
                .collect(toList());
    }

    public void createUser(AppUser appUser) {
        appUser.setPassword(new BCryptPasswordEncoder().encode(appUser.getPassword()));
        appUserRepo.save(appUser);
    }

    public AppUser getCurrentUserInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return appUserRepo.findByUsername(user.getUsername());
    }
}
