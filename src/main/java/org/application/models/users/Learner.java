package org.application.models.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.application.models.requests.TrainerRequest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Learner extends AppUser{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requester")
    private List<TrainerRequest> trainerRequests;
}
