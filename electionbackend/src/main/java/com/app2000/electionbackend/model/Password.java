package com.app2000.electionbackend.model;

import org.springframework.messaging.handler.annotation.Header;

public class Password {
    private final String password;

    public Password(@Header String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
