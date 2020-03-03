package org.application.services;

import org.application.repositories.requests.TrainerRequestRepo;
import org.springframework.stereotype.Service;

@Service
public class TrainerRequestService {

    final
    TrainerRequestRepo trainerRequestRepo;

    public TrainerRequestService(TrainerRequestRepo trainerRequestRepo) {
        this.trainerRequestRepo = trainerRequestRepo;
    }
}
