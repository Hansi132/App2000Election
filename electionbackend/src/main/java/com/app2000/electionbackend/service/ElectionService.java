package com.app2000.electionbackend.service;

import com.app2000.electionbackend.db.ElectionDB;
import com.app2000.electionbackend.model.Election;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@Service
public class ElectionService {
    private final ElectionDB electionDB;

    @Autowired
    public ElectionService(@Qualifier("Election") ElectionDB electionDB) {
        this.electionDB = electionDB;
    }

    public List<Election> getAllElections() throws SQLException {
        return electionDB.getAllElections();
    }

    public void createElection(Election election) throws SQLException {
        electionDB.createElection(election);
    }

    public Boolean getActiveElection(Date electionStart, Date electionEnd) throws SQLException {
        return electionDB.getActiveElection(electionStart, electionEnd);
    }
}
