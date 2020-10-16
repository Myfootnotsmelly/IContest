package com.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public  class User {
    private int Id;
    private String Username;
    private String Password;
    private String NickName;
    private List<Team> teamList = new ArrayList<>();

    public User(){this(null,null,null);}

    public User( String username, String password, String nickName) {
        Username = username;
        Password = password;
        NickName = nickName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return Username;
    }

    public void setUserName(String userName) {
        Username = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", NickName='" + NickName + '\'' +
                ", teamList=" + teamList +
                '}';
    }
}

