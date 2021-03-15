package com.app2000.electionbackend.service;

import com.app2000.electionbackend.db.ProfilePictureDB;
import com.app2000.electionbackend.model.ProfilePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfilePictureService {
    private final ProfilePictureDB profilePictureDB;

    @Autowired
    public ProfilePictureService(@Qualifier("ProfilePicture") ProfilePictureDB profilePictureDB) {
        this.profilePictureDB = profilePictureDB;
    }

    public List<ProfilePicture> getAllProfilePictures() throws SQLException {
        return profilePictureDB.getAllProfilePictures();
    }
}
