package com.app2000.electionbackend.test;

import com.app2000.electionbackend.db.NominatedPersonDataAccess;
import com.app2000.electionbackend.model.NominatedPerson;
import com.app2000.electionbackend.util.JsonPrinter;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;


import java.sql.SQLException;
import java.util.List;

public class NominatedPersonTest {
    private static final Logger log = LogManager.getLogger(NominatedPersonTest.class);

    @BeforeClass
    public static void setUp() {
        log.info("Setting up all variables");
    }

    @Test
    public void getAllNominatedPerson() throws SQLException {
        List<NominatedPerson> list = new NominatedPersonDataAccess().getAllNominatedPerson();
        log.info("Recieved: " + list.size() + " nominated persons\n" + JsonPrinter.print(list));
    }

}
