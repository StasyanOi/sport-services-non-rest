package org.application.services;

import org.application.models.users.AppUser;
import org.application.repositories.users.AppUserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AppUserService {

    final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Transactional
    public List<AppUser> getTrainers() {
        List<AppUser> all = appUserRepo.findAll();

        return all.stream()
                .filter(appUser -> appUser.getAuthority().equals("ROLE_TRAINER"))
                .collect(toList());
    }

    @Transactional
    public void createUser(AppUser appUser) {
        appUser.setPassword(new BCryptPasswordEncoder().encode(appUser.getPassword()));
        appUserRepo.save(appUser);
    }

    @Transactional
    public AppUser getCurrentUserInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return appUserRepo.findByUsername(user.getUsername());
    }
}
