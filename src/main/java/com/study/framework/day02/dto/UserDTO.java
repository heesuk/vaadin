package com.study.framework.day02.dto;

public class UserDTO {
    private String username;
    private String password;

    public String getUserNAme() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
