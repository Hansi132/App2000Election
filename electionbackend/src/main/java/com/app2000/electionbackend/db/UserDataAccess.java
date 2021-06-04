package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.User;
import com.app2000.electionbackend.model.UserType;
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
        String insertSql = "INSERT INTO User(Email, UserTypeId, Name, PictureId, hasVoted) VALUES (?,?,?,?,?);";
        PreparedStatement insertStmt = connection.prepareStatement(insertSql);
        insertStmt.setString(1, user.getEmail());
        insertStmt.setInt(2, user.getUserTypeId());
        insertStmt.setString(3, user.getName());
        insertStmt.setInt(4, user.getPictureId());
        insertStmt.setBoolean(5, user.isHasVoted());
        insertStmt.execute();
        System.out.print("We got here");
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
                    resultSet.getInt("UserId"), resultSet.getString("Email"),
                    resultSet.getInt("UserTypeId"), resultSet.getString("Name"),
                    resultSet.getInt("PictureId"), resultSet.getBoolean("hasVoted"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User selectOneUser(String email) throws SQLException {
        String selectSql = "SELECT * FROM User WHERE Email = ?;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        selectStmt.setString(1, email);
        ResultSet resultSet = selectStmt.executeQuery();
        if (resultSet.next()) {
            return new User(
                    resultSet.getInt("UserId"), resultSet.getString("Email"),
                    resultSet.getInt("UserTypeId"), resultSet.getString("Name"),
                    resultSet.getInt("PictureId"), resultSet.getBoolean("hasVoted"));
        } else {
            return null;
        }
    }

    @Override
    public int updateVote(String email, User user) throws SQLException {
        String updateSql = "UPDATE User SET hasVoted = ? WHERE Email = ?";
        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
        updateStmt.setBoolean(1, user.isHasVoted());
        updateStmt.setString(2, email);
        updateStmt.execute();
        return 1;
    }

    @Override
    public User selectUserOnId(Integer userId) throws SQLException {
        String selectSql = "SELECT * FROM User WHERE UserId = ?;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        selectStmt.setInt(1, userId);
        ResultSet resultSet = selectStmt.executeQuery();
        if (resultSet.next()) {
            return new User(
                    resultSet.getInt("UserId"), resultSet.getString("Email"),
                    resultSet.getInt("UserTypeId"), resultSet.getString("Name"),
                    resultSet.getInt("PictureId"), resultSet.getBoolean("hasVoted"));
        } else {
            return null;
        }
    }

    @Override
    public UserType getUserType(Integer userId) throws SQLException {
        String selectSql = "SELECT * FROM UserType LEFT JOIN User U on UserType.UserTypeId = U.UserTypeId WHERE UserId = ?;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        selectStmt.setInt(1, userId);
        ResultSet rs = selectStmt.executeQuery();
        if (rs.next()) {
            return new UserType(rs.getInt("UserType.UserTypeId"), rs.getString("UserTypeDesc"));
        } else {
            return null;
        }
    }
}
