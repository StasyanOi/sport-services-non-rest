package org.application.resources;

import lombok.NoArgsConstructor;
import org.application.models.custom.RequestRecord;
import org.application.repositories.custom.RequestRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public RequestRecord getRecord(@PathVariable("id") long id) throws SQLException {
        return requestRecordRepo.get(id);
    }

}
