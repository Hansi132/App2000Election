package com.app2000.electionbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NominatedPerson {
    private final int UserId;
    private final String Faculty;
    private final String Institute;
    private final String Information;
    private final int Votes;

    public NominatedPerson(@JsonProperty("userId") int userId,
                           @JsonProperty("faculty") String faculty,
                           @JsonProperty("institute") String institute,
                           @JsonProperty("information") String information,
                           @JsonProperty("votes") int votes) {
        UserId = userId;
        Faculty = faculty;
        Institute = institute;
        Information = information;
        Votes = votes;
    }

    public int getVotes() {
        return Votes;
    }

    public String getInformation() {
        return Information;
    }

    public String getInstitute() {
        return Institute;
    }

    public String getFaculty() {
        return Faculty;
    }

    public int getUserId() {
        return UserId;
    }
}
