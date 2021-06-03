package com.app2000.electionbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfilePicture {
    private final int PictureId;
    private final String Path;

    public ProfilePicture(@JsonProperty Integer pictureId, @JsonProperty String path) {
        PictureId = pictureId;
        Path = path;
    }

    public String getPath() {
        return Path;
    }

    public int getPictureId() {
        return PictureId;
    }
}
