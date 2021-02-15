package com.app2000.electionbackend.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
public class DatabaseConnection {
    public static Connection connect() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://92.220.179.219:3306/USN_ELECTION", "election_user", "usn_election_user"
        );
    }

}
