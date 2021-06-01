package com.app2000.electionbackend.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/v1/userInfo")
@RestController
public class UserPrincipalController {
    @GetMapping
    public Map<String, String> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("name", principal.getAttribute("name"));
        userInfo.put("email", principal.getName());
        return userInfo;
    }
}
