package com.app2000.electionbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private final int id;
    private final String email;
    private final String fName;
    private final String lName;
    private final String password;
    private final String fDate;
    private final String gender;

    public User(int id,
                @JsonProperty("email") String email,
                @JsonProperty("fname") String fName,
                @JsonProperty("lname") String lName,
                @JsonProperty("password") String password,
                @JsonProperty("fDate") String fDate,
                @JsonProperty("gender") String gender) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.fDate = fDate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPassword() {
        return password;
    }

    public String getfDate() {
        return fDate;
    }

    public String getGender() {
        return gender;
    }
}
