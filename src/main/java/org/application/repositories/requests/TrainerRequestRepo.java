package org.application.repositories.requests;

import org.application.models.requests.TrainerRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRequestRepo extends JpaRepository<TrainerRequest,Long> {
}
