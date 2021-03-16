package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.ProfilePicture;
import com.app2000.electionbackend.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("ProfilePicture")
public class ProfilePictureDataAccess implements ProfilePictureDB{
    private static Connection connection;
    static {
        try {
            connection = DatabaseConnection.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ProfilePicture> getAllProfilePictures() throws SQLException {
        List<ProfilePicture> list = new ArrayList<>();
        String selectSql = "SELECT * FROM ProfilePicture;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        ResultSet resultSet = selectStmt.executeQuery();
        while (resultSet.next()) {
            ProfilePicture profilePicture = new ProfilePicture(
                    resultSet.getInt("PictureId"),
                    resultSet.getString("Path")
            );
            list.add(profilePicture);
        }
        return list;
    }
}
