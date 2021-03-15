package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface UserDB {

    int insertUser(User user) throws SQLException;

    List<User> selectAllUsers() throws SQLException;

    User selectOneUser(int id) throws SQLException;
}
