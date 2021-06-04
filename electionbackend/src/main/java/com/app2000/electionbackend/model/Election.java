package com.app2000.electionbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Election {
    private int electionId;
    private Date electionStart;
    private Date electionEnd;
    private Boolean controlled;
    private Integer electedUserId;

    public Election(int electionId) {
        this.electionId = electionId;
    }

    public Election(@JsonProperty("electionId") int electionId,
                    @JsonProperty("electionId") Date electionStart,
                    @JsonProperty("electionId") Date electionEnd,
                    @JsonProperty("electionId") Boolean controlled,
                    @JsonProperty("electionId") Integer electedUserId) {
        this.electionId = electionId;
        this.electionStart = electionStart;
        this.electionEnd = electionEnd;
        this.controlled = controlled;
        this.electedUserId = electedUserId;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }

    public Date getElectionStart() {
        return electionStart;
    }

    public void setElectionStart(Date electionStart) {
        this.electionStart = electionStart;
    }

    public Date getElectionEnd() {
        return electionEnd;
    }

    public void setElectionEnd(Date electionEnd) {
        this.electionEnd = electionEnd;
    }

    public Boolean getControlled() {
        return controlled;
    }

    public void setControlled(Boolean controlled) {
        this.controlled = controlled;
    }

    public Integer getElectedUserId() {
        return electedUserId;
    }

    public void setElectedUserId(Integer electedUserId) {
        this.electedUserId = electedUserId;
    }
}
