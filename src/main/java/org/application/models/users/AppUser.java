package org.application.models.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.application.models.requests.RoomRequest;
import org.application.models.requests.TrainerRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"password","trainerRequests","roomRequests","enabled"})
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column
    private String authority;

    @Column
    private Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requester")
    private List<TrainerRequest> trainerRequests;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requester")
    private List<RoomRequest> roomRequests;

}
