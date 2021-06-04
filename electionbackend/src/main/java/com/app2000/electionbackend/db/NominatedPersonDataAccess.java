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
    public boolean addVote(NominatedPerson nominatedPerson) throws SQLException {
        String updateSql = "UPDATE NominatedPerson SET Votes = Votes + 1 WHERE UserId = ?;";
        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
        updateStmt.setInt(1, nominatedPerson.getUserId());
        try {
            updateStmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public int insertNominatedPerson(NominatedPerson nominatedPerson) throws SQLException {
        String insertSql = "INSERT INTO NominatedPerson VALUES (?,?,?,?,?);";
        PreparedStatement insertStmt = connection.prepareStatement(insertSql);
        insertStmt.setInt(1, nominatedPerson.getUserId());
        insertStmt.setString(2, nominatedPerson.getFaculty());
        insertStmt.setString(3, nominatedPerson.getInstitute());
        insertStmt.setString(4, nominatedPerson.getInformation());
        insertStmt.setInt(5, nominatedPerson.getVotes());
        insertStmt.execute();
        return 1;
    }

    @Override
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
                    resultSet.getInt("Votes"));
            nominatedPersonList.add(nominatedPerson);
        }
        return nominatedPersonList;
    }

    @Override
    public void withdrawFromElection(Integer userId) throws SQLException {
        String deleteSql = "DELETE FROM NominatedPerson WHERE UserId = ?";
        PreparedStatement ps = connection.prepareStatement(deleteSql);
        ps.setInt(1, userId);
        ps.execute();
    }

    @Override
    public List<NominatedPerson> getTop5() throws SQLException{
        List<NominatedPerson> nominatedPersonList = new ArrayList<>();
        String selectSql = "SELECT * FROM NominatedPerson ORDER BY Votes DESC LIMIT 5;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        ResultSet resultSet = selectStmt.executeQuery();
        while (resultSet.next()) {
            NominatedPerson nominatedPerson = new NominatedPerson(
                    resultSet.getInt("UserId"),
                    resultSet.getString("Faculty"),
                    resultSet.getString("Institute"),
                    resultSet.getString("Information"),
                    resultSet.getInt("Votes"));
            nominatedPersonList.add(nominatedPerson);
        }
        return nominatedPersonList;
    }
}
