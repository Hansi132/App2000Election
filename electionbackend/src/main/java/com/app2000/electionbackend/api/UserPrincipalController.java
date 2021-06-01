package com.app2000.electionbackend.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/v1/userInfo")
@RestController
public class UserPrincipalController {
    @GetMapping
    public Map<String, String> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String namePartOne = authentication.getPrincipal().toString().substring(authentication.getPrincipal().toString().lastIndexOf("name") + 5);
        String name = namePartOne.substring(0, authentication.getPrincipal().toString().indexOf(",") + 1);
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("name", name);
        userInfo.put("email", authentication.getName());
        return userInfo;
    }
}
