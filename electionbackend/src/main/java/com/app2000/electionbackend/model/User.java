package com.app2000.electionbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private final int id;
    private final String email;
    private final int userTypeId;
    private final String name;
    private int pictureId;
    private boolean hasVoted;
    public User(Integer id,
                @JsonProperty("email") String email,
                @JsonProperty("userTypeID") int userTypeId,
                @JsonProperty("name") String name,
                @JsonProperty("pictureId") int pictureId, @JsonProperty("hasVoted") boolean hasVoted) {
        this.id = id;
        this.email = email;
        this.userTypeId = userTypeId;
        this.name = name;
        this.pictureId = pictureId;
        this.hasVoted = hasVoted;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public String getName() {
        return name;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
