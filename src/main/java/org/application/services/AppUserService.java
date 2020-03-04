package org.application.services;

import org.application.models.users.AppUser;
import org.application.repositories.users.AppUserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}
