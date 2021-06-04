package com.app2000.electionbackend.service;

import com.app2000.electionbackend.db.NominatedPersonDB;
import com.app2000.electionbackend.model.NominatedPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NominatedPersonService {
    private final NominatedPersonDB nominatedPersonDB;

    @Autowired
    public NominatedPersonService(@Qualifier("NominatedPerson") NominatedPersonDB nominatedPersonDB) {
        this.nominatedPersonDB = nominatedPersonDB;
    }

    public int addNominatedPerson(NominatedPerson nominatedPerson) throws SQLException {
        return nominatedPersonDB.insertNominatedPerson(nominatedPerson);
    }

    public List<NominatedPerson> getAllNominatedPersons() throws SQLException {
        return nominatedPersonDB.getAllNominatedPerson();
    }

    public boolean addVote(NominatedPerson nominatedPerson) throws SQLException {
        return nominatedPersonDB.addVote(nominatedPerson);
    }

    public void withdrawFromElection(Integer userId) throws SQLException{
        nominatedPersonDB.withdrawFromElection(userId);
    }

    public List<NominatedPerson> getTop5() throws SQLException {
        return nominatedPersonDB.getTop5();
    }
}
