package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.Election;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface ElectionDB {
    List<Election> getAllElections() throws SQLException;

    void createElection(Election election) throws SQLException;

    Election getActiveElection(Date electionStart, Date electionEnd) throws SQLException;
}
