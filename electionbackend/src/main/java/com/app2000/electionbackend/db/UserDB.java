package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDB {

    int insertUser(User user) throws SQLException;

    List<User> selectAllUsers() throws SQLException;

    User selectOneUser(String email) throws SQLException;

    int updateVote(String email, User user) throws SQLException;
}
