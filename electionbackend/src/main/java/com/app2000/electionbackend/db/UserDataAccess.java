package com.app2000.electionbackend.db;

import com.app2000.electionbackend.exception.UserNotFoundException;
import com.app2000.electionbackend.model.User;
import com.app2000.electionbackend.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("User")
public class UserDataAccess implements UserDB {

    private static Connection connection;

    static {
        try {
            connection = DatabaseConnection.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertUser(User user) throws SQLException {
        String insertSql = "INSERT INTO User(Email, FName, LName, FDate, Password, Gender) VALUES (?,?,?,?,?,?);";
        PreparedStatement insertStmt = connection.prepareStatement(insertSql);
        insertStmt.setString(1, user.getEmail());
        insertStmt.setString(2, user.getfName());
        insertStmt.setString(3, user.getlName());
        insertStmt.setString(4, user.getfDate());
        insertStmt.setString(5, user.getPassword());
        insertStmt.setString(6, user.getGender());
        insertStmt.execute();
        System.out.print("We got here");
        connection.close();
        return 1;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String selectSql = "SELECT * FROM User;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        ResultSet resultSet = selectStmt.executeQuery();
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("UserId"),
                    resultSet.getString("Email"),
                    resultSet.getString("FName"),
                    resultSet.getString("LName"),
                    "",
                    resultSet.getString("FDate"),
                    resultSet.getString("Gender"));
            userList.add(user);
        }
        connection.close();
        return userList;
    }

    @Override
    public User selectOneUser(int id) throws SQLException {
        String selectSql = "SELECT * FROM User WHERE UserId = ?;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        selectStmt.setInt(1, id);
        ResultSet resultSet = selectStmt.executeQuery();
        if (resultSet.next()) {
            connection.close();
            return new User(
                    resultSet.getInt("UserId"),
                    resultSet.getString("Email"),
                    resultSet.getString("FName"),
                    resultSet.getString("LName"),
                    "",
                    resultSet.getString("FDate"),
                    resultSet.getString("Gender"));
        } else {
            connection.close();
            throw new UserNotFoundException("No user is found with that id");
        }
    }
}
