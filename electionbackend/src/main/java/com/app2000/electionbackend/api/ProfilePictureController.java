package com.app2000.electionbackend.api;

import com.app2000.electionbackend.model.ProfilePicture;
import com.app2000.electionbackend.service.ProfilePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("/api/v1/profilePicture")
@RestController
@CrossOrigin
public class ProfilePictureController {
    private final ProfilePictureService profilePictureService;

    @Autowired
    public ProfilePictureController(ProfilePictureService profilePictureService) {
        this.profilePictureService = profilePictureService;
    }

    @GetMapping
    public List<ProfilePicture> getAllProfilePictures() throws SQLException {
        return profilePictureService.getAllProfilePictures();
    }
}
