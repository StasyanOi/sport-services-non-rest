package org.application.services;

import org.application.models.custom.RequestRecord;
import org.application.models.requests.TrainerRequest;
import org.application.models.users.AppUser;
import org.application.models.users.Learner;
import org.application.repositories.custom.RequestRecordRepo;
import org.application.repositories.requests.TrainerRequestRepo;
import org.application.repositories.users.AppUserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TrainerRequestService {

    private RequestRecordRepo requestRecordRepo;

    private TrainerRequestRepo trainerRequestRepo;

    private AppUserRepo appUserRepo;

    public TrainerRequestService(TrainerRequestRepo trainerRequestRepo, AppUserRepo appUserRepo, RequestRecordRepo requestRecordRepo) {
        this.trainerRequestRepo = trainerRequestRepo;
        this.appUserRepo = appUserRepo;
        this.requestRecordRepo = requestRecordRepo;
    }

    @Transactional
    public void addTrainerRequest(Long trainerId, LocalDateTime start, LocalDateTime end) throws SQLException {
        User auth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser trainer = appUserRepo.getOne(trainerId);
        AppUser user = appUserRepo.findByUsername(auth.getUsername());
        TrainerRequest trainerRequest = new TrainerRequest();
        trainerRequest.setRequester(user);
        trainerRequest.setTrainer(trainer);
        trainerRequest.setStartTime(Timestamp.valueOf(start));
        trainerRequest.setEndTime(Timestamp.valueOf(end));
        ((Learner) user).getTrainerRequests().add(trainerRequest);
        trainerRequestRepo.save(trainerRequest);
        requestRecordRepo.save(new RequestRecord("TRAIN_REQ", trainerRequest.getRequester().toString(),
                trainerRequest.getTrainer().toString(), LocalDate.now()));
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

    @Transactional
    public void removeRequest(Long requestId) {
        TrainerRequest matchedRequest = trainerRequestRepo.getOne(requestId);
        matchedRequest.setRequester(null);
        matchedRequest.setTrainer(null);
        trainerRequestRepo.delete(requestId);
    }
}
