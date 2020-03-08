package org.application.services;

import org.application.models.Room;
import org.application.models.requests.RoomRequest;
import org.application.models.users.AppUser;
import org.application.repositories.RoomRepo;
import org.application.repositories.requests.RoomRequestRepo;
import org.application.repositories.users.AppUserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class RoomRequestService {

    final
    RoomRequestRepo roomRequestRepo;

    final
    AppUserRepo appUserRepo;

    final
    RoomRepo roomRepo;

    public RoomRequestService(RoomRequestRepo roomRequestRepo, AppUserRepo appUserRepo, RoomRepo roomRepo) {
        this.roomRequestRepo = roomRequestRepo;
        this.appUserRepo = appUserRepo;
        this.roomRepo = roomRepo;
    }

    @Transactional
    public void addRoomRequest(Long roomId) {
        User auth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Room room = roomRepo.getOne(roomId);
        AppUser user = appUserRepo.findByUsername(auth.getUsername());
        RoomRequest roomRequest = new RoomRequest();
        roomRequest.setRequester(user);
        roomRequest.setRoom(room);
        user.getRoomRequests().add(roomRequest);
        roomRequestRepo.save(roomRequest);
    }

    @Transactional
    public List<RoomRequest> getAll() {
        return roomRequestRepo.findAll();
    }

    @Transactional
    public List<RoomRequest> getUnaprovedRequests() {
        return getAll().stream().filter(roomRequest -> !roomRequest.getApproved()).collect(toList());
    }

    @Transactional
    public void approveRequest(Long requestId) {
        RoomRequest one = roomRequestRepo.getOne(requestId);
        one.setApproved(true);
    }
}
