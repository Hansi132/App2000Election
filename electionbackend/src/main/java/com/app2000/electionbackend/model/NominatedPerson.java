package com.app2000.electionbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NominatedPerson {
    private final int UserId;
    private final String Faculty;
    private final String Institute;
    private final String Information;
    private final int Votes;
    private final int PictureId;

    public NominatedPerson(@JsonProperty("userId") int userId,
                           @JsonProperty("faculty") String faculty,
                           @JsonProperty("institute") String institute,
                           @JsonProperty("information") String information,
                           @JsonProperty("votes") int votes,
                           @JsonProperty("pictureId") int pictureId) {
        UserId = userId;
        Faculty = faculty;
        Institute = institute;
        Information = information;
        Votes = votes;
        PictureId = pictureId;
    }

    public int getPictureId() {
        return PictureId;
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
