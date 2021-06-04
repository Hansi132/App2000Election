package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.NominatedPerson;

import java.sql.SQLException;
import java.util.List;

public interface NominatedPersonDB {

    boolean addVote(NominatedPerson nominatedPerson) throws SQLException;

    int insertNominatedPerson(NominatedPerson nominatedPerson) throws SQLException;

    List<NominatedPerson> getAllNominatedPerson() throws SQLException;

    void withdrawFromElection(Integer userId) throws SQLException;

    List<NominatedPerson> getTop5() throws SQLException;
}
