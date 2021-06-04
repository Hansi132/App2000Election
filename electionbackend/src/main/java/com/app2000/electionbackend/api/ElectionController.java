package com.app2000.electionbackend.api;

import com.app2000.electionbackend.model.Election;
import com.app2000.electionbackend.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("/api/v1/election")
@RestController
@CrossOrigin
public class ElectionController {

    private final ElectionService electionService;

    @Autowired
    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    @GetMapping
    public List<Election> getAllElections() throws SQLException {
        return electionService.getAllElections();
    }

    @PostMapping
    public void createElection(@RequestBody Election election) throws SQLException {
        electionService.createElection(election);
    }

    @GetMapping("/active")
    public Boolean getActiveElection(@RequestParam Long electionStart1, @RequestParam Long electionEnd1) throws SQLException {
        Date electionStart = new Date(electionStart1);
        Date electionEnd = new Date(electionEnd1);
        return electionService.getActiveElection(electionStart, electionEnd);
    }
}
