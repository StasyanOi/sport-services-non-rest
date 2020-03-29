package org.application.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.application.models.Room;
import org.application.models.users.AppUser;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RoomRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AppUser requester;

    @OneToOne
    private Room room;

    @Column
    private Boolean approvedAdmin = false;

    @Column
    private Boolean approvedSecurity = false;


}
