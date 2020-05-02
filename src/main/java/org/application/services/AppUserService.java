package org.application.services;

import org.application.models.users.*;
import org.application.repositories.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;

    private final TrainerRepo trainerRepo;

    private final AdminRepo adminRepo;

    private final SecurityRepo securityRepo;

    private final LearnerRepo learnerRepo;

    public AppUserService(AppUserRepo appUserRepo, TrainerRepo trainerRepo, AdminRepo adminRepo, SecurityRepo securityRepo, LearnerRepo learnerRepo) {
        this.appUserRepo = appUserRepo;
        this.trainerRepo = trainerRepo;
        this.adminRepo = adminRepo;
        this.securityRepo = securityRepo;
        this.learnerRepo = learnerRepo;
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

        String authority = appUser.getAuthority();

        if (authority.equals("ROLE_TRAINER")) {
            Trainer trainer = new Trainer();
            trainer.apply(appUser);
            trainerRepo.save(trainer);
        } else if (authority.equals("ROLE_USER")) {
            Learner learner = new Learner();
            learner.apply(appUser);
            learnerRepo.save(learner);
        } else if (authority.equals("ROLE_ADMIN")) {
            Admin admin = new Admin();
            admin.apply(appUser);
            adminRepo.save(admin);
        } else if (authority.equals("ROLE_SECURITY")) {
            SecurityUser securityUser = new SecurityUser();
            securityUser.apply(appUser);
            securityRepo.save(securityUser);
        } else {
            throw new IllegalArgumentException("Broken role");
        }
    }

    @Transactional
    public AppUser getCurrentUserInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return appUserRepo.findByUsername(user.getUsername());
    }
}
