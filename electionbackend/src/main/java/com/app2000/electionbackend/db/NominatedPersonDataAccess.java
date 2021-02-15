package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.NominatedPerson;
import com.app2000.electionbackend.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("NominatedPerson")
public class NominatedPersonDataAccess implements NominatedPersonDB{

    private static Connection connection;

    static {
        try {
            connection = DatabaseConnection.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertNominatedPerson(NominatedPerson nominatedPerson) throws SQLException {
        String insertSql = "INSERT INTO NominatedPerson VALUES (?,?,?,?,?,?);";
        PreparedStatement insertStmt = connection.prepareStatement(insertSql);
        insertStmt.setInt(1, nominatedPerson.getUserId());
        insertStmt.setString(2, nominatedPerson.getFaculty());
        insertStmt.setString(3, nominatedPerson.getInstitute());
        insertStmt.setString(4, nominatedPerson.getInformation());
        insertStmt.setInt(5, nominatedPerson.getVotes());
        insertStmt.setInt(6, nominatedPerson.getPictureId());
        insertStmt.execute();
        return 1;
    }

    public List<NominatedPerson> getAllNominatedPerson() throws SQLException {
        List<NominatedPerson> nominatedPersonList = new ArrayList<>();
        String selectSql = "SELECT * FROM NominatedPerson;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        ResultSet resultSet = selectStmt.executeQuery();
        while (resultSet.next()) {
            NominatedPerson nominatedPerson = new NominatedPerson(
                    resultSet.getInt("UserId"),
                    resultSet.getString("Faculty"),
                    resultSet.getString("Institute"),
                    resultSet.getString("Information"),
                    resultSet.getInt("Votes"),
                    resultSet.getInt("PictureId"));
            nominatedPersonList.add(nominatedPerson);
        }
        return nominatedPersonList;
    }
}
