package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.ProfilePicture;

import java.sql.SQLException;
import java.util.List;

public interface ProfilePictureDB {

    List<ProfilePicture> getAllProfilePictures() throws SQLException;

    int insertProfilePicture(ProfilePicture profilePicture) throws SQLException;

    String getUserProfilePicture(int pictureId) throws SQLException;
}
