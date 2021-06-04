package com.app2000.electionbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Election {
    private Integer electionId;
    private Date electionStart;
    private Date electionEnd;
    private Boolean controlled;
    private Integer electedUserId;

    public Election(Integer electionId) {
        this.electionId = electionId;
    }

    public Election(@JsonProperty("electionId") Integer electionId,
                    @JsonProperty("electionStart") Date electionStart,
                    @JsonProperty("electionEnd") Date electionEnd,
                    @JsonProperty("controlled") Boolean controlled,
                    @JsonProperty("electedUserId") Integer electedUserId) {
        this.electionId = electionId;
        this.electionStart = electionStart;
        this.electionEnd = electionEnd;
        this.controlled = controlled;
        this.electedUserId = electedUserId;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
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
