package com.app2000.electionbackend.db;

import com.app2000.electionbackend.model.Election;
import com.app2000.electionbackend.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("Election")
public class ElectionDataAccess implements ElectionDB {

    private static Connection connection;

    static {
        try {
            connection = DatabaseConnection.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Election> getAllElections() throws SQLException {
        List<Election> electionList = new ArrayList<>();
        String selectSql = "SELECT * FROM Election;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        ResultSet resultSet = selectStmt.executeQuery();
        while (resultSet.next()) {
            Election election = new Election(
                    resultSet.getInt("ElectionId"),
                    resultSet.getDate("ElectionStart"),
                    resultSet.getDate("ElectionEnd"),
                    resultSet.getBoolean("Controlled"),
                    resultSet.getInt("ElectedUserId"));
            electionList.add(election);
        }
        return electionList;
    }

    @Override
    public void createElection(Election election) throws SQLException {
        String insertSql = "INSERT INTO Election (ElectionStart, ElectionEnd, Controlled, ElectedUserId) VALUES (?,?,?,?);";
        PreparedStatement insertStmt = connection.prepareStatement(insertSql);
        insertStmt.setDate(1, election.getElectionStart());
        insertStmt.setDate(2, election.getElectionEnd());
        insertStmt.setBoolean(3, election.getControlled());
        if (election.getElectedUserId() != null) {
            insertStmt.setInt(4, election.getElectedUserId());
        } else {
            insertStmt.setNull(4, Types.NULL);
        }

    }

    @Override
    public Election getActiveElection(Date electionStart, Date electionEnd) throws SQLException {
        String selectSql = "SELECT * FROM Election WHERE ElectionEnd < ? AND ElectionStart > ? LIMIT 1;";
        PreparedStatement selectStmt = connection.prepareStatement(selectSql);
        selectStmt.setDate(1, electionEnd);
        selectStmt.setDate(2, electionStart);
        ResultSet resultSet = selectStmt.executeQuery();
        if (resultSet.next()) {
            return new Election(
                    resultSet.getInt("ElectionId"),
                    resultSet.getDate("ElectionStart"),
                    resultSet.getDate("ElectionEnd"),
                    resultSet.getBoolean("Controlled"),
                    resultSet.getInt("ElectedUserId"));
        } else {
            return null;
        }
    }

}
