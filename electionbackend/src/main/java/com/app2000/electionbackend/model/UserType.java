package com.app2000.electionbackend.model;

public class UserType {
    private Integer userTypeId;
    private String userTypeDesc;

    public UserType(Integer userTypeId, String userTypeDesc) {
        this.userTypeId = userTypeId;
        this.userTypeDesc = userTypeDesc;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeDesc() {
        return userTypeDesc;
    }

    public void setUserTypeDesc(String userTypeDesc) {
        this.userTypeDesc = userTypeDesc;
    }
}
