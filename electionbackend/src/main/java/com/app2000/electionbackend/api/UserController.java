package com.app2000.electionbackend.api;

import com.app2000.electionbackend.model.User;
import com.app2000.electionbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("/api/v1/user")
@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user) throws SQLException {
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() throws SQLException {
        return userService.getAllUsers();
    }

    @GetMapping("/id")
    public User selectOneUser(@RequestParam int id) throws SQLException {
        return userService.selectOneUser(id);
    }
}
