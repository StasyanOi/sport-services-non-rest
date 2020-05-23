package org.application.resources;

import lombok.NoArgsConstructor;
import org.application.models.custom.RequestRecord;
import org.application.models.users.AppUser;
import org.application.repositories.custom.RequestRecordRepo;
import org.application.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/records")
public class RecordResource {

    private RequestRecordRepo requestRecordRepo;

    @Autowired
    public RecordResource(RequestRecordRepo requestRecordRepo) {
        this.requestRecordRepo = requestRecordRepo;
    }


    @GetMapping
    public List<RequestRecord> getRecords() throws SQLException {
        return requestRecordRepo.getAll();
    }

}
