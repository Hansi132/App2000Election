package com.app2000.electionbackend.service;

import com.app2000.electionbackend.db.UserDB;
import com.app2000.electionbackend.model.User;
import com.app2000.electionbackend.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    private final UserDB userDB;

    @Autowired
    public UserService(@Qualifier("User") UserDB userDB) {
        this.userDB = userDB;
    }

    public int addUser(User user) throws SQLException {
        return userDB.insertUser(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDB.selectAllUsers();
    }

    public User selectOneUser(String email) throws SQLException {
        return userDB.selectOneUser(email);
    }

    public int updateVote(String email, User user) throws SQLException {
        return userDB.updateVote(email, user);
    }

    public User selectUserOnId(Integer userId) throws SQLException {
        return userDB.selectUserOnId(userId);
    }

    public UserType getUserType(Integer userId) throws SQLException {
        return userDB.getUserType(userId);
    }
}
