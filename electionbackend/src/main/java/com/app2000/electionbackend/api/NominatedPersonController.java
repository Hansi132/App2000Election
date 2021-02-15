package com.app2000.electionbackend.api;

import com.app2000.electionbackend.model.NominatedPerson;
import com.app2000.electionbackend.service.NominatedPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("/api/v1/nominatedPerson")
@RestController
@CrossOrigin
public class NominatedPersonController {

    private final NominatedPersonService nominatedPersonService;

    @Autowired
    public NominatedPersonController(NominatedPersonService nominatedPersonService) {
        this.nominatedPersonService = nominatedPersonService;
    }

    @PostMapping
    public void addNominatedPerson(@RequestBody NominatedPerson nominatedPerson) throws SQLException {
        nominatedPersonService.addNominatedPerson(nominatedPerson);
    }

    @GetMapping()
    public List<NominatedPerson> getAllNominatedPersons() throws SQLException {
        return nominatedPersonService.getAllNominatedPersons();
    }
}
