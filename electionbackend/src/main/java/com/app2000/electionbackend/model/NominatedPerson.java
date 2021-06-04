package com.app2000.electionbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NominatedPerson {
    private int UserId;
    private String Faculty;
    private String Institute;
    private String Information;
    private int Votes;

    public NominatedPerson(@JsonProperty("userId") int userId,
                           @JsonProperty("faculty") String faculty,
                           @JsonProperty("institute") String institute,
                           @JsonProperty("information") String information,
                           @JsonProperty("votes") int votes) {
        this.UserId = userId;
        this.Faculty = faculty;
        this.Institute = institute;
        this.Information = information;
        this.Votes = votes;
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
