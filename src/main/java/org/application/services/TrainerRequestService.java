package org.application.services;

import org.application.models.requests.TrainerRequest;
import org.application.models.users.AppUser;
import org.application.repositories.requests.TrainerRequestRepo;
import org.application.repositories.users.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TrainerRequestService {

    final
    TrainerRequestRepo trainerRequestRepo;

    final
    AppUserRepo appUserRepo;

    public TrainerRequestService(TrainerRequestRepo trainerRequestRepo, AppUserRepo appUserRepo) {
        this.trainerRequestRepo = trainerRequestRepo;
        this.appUserRepo = appUserRepo;
    }

    @Transactional
    public void addTrainerRequest(Long trainerId) {
        User auth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser trainer = appUserRepo.getOne(trainerId);
        AppUser user = appUserRepo.findByUsername(auth.getUsername());
        TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setRequester(user);
        trainerRequest.setTrainer(trainer);
        user.getTrainerRequests().add(trainerRequest);
        trainerRequestRepo.save(trainerRequest);
    }

    @Transactional
    public List<TrainerRequest> getAll() {
        return trainerRequestRepo.findAll();
    }

    @Transactional
    public List<TrainerRequest> getRequestsForTrainer(AppUser trainer) {
        return trainerRequestRepo.findByTrainer(trainer);
    }

    @Transactional
    public void approveRequestTrainer(Long requestId) {
        TrainerRequest one = trainerRequestRepo.getOne(requestId);
        one.setApprovedTrainer(true);
    }

    @Transactional
    public void approveRequestSecurity(Long requestId) {
        TrainerRequest one = trainerRequestRepo.getOne(requestId);
        one.setApprovedSecurity(true);
    }

    @Transactional
    public List<TrainerRequest> getUnapprovedRequests() {
        return getAll().stream().filter(trainerRequest -> (!trainerRequest.getApprovedTrainer() | !trainerRequest.getApprovedSecurity())).collect(toList());
    }
}
