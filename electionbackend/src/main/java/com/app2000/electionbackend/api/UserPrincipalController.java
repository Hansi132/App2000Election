package com.app2000.electionbackend.api;

import com.app2000.electionbackend.model.ProfilePicture;
import com.app2000.electionbackend.model.User;
import com.app2000.electionbackend.service.ProfilePictureService;
import com.app2000.electionbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/v1/userInfo")
@RestController
public class UserPrincipalController {

    private final UserService userService;

    @Autowired
    public UserPrincipalController(UserService userService, ProfilePictureService profilePictureService) {
        this.userService = userService;
        this.profilePictureService = profilePictureService;
    }

    private final ProfilePictureService profilePictureService;


    @GetMapping
    public Map<String, String> getUserInfo(@AuthenticationPrincipal OAuth2User principal) throws SQLException {
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("name", principal.getAttribute("name"));
        userInfo.put("email", principal.getName());
        userInfo.put("picture", principal.getAttribute("picture"));
        User user = userService.selectOneUser(principal.getName());
        if (user == null) {
            userService.addUser(new User(1, principal.getName(), 1, principal.getAttribute("name"), profilePictureService.insertProfilePicture(new ProfilePicture(1, principal.getAttribute("picture"))), false));
        }
        return userInfo;
    }
}
