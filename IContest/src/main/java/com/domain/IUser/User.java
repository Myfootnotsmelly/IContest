package com.domain.IUser;

import com.domain.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public  class User implements Serializable {
    private Integer Id;
    private String Username;
    private String Password;
    private String Nickname;
    private List<Team> teamList;

    public User(){this(null,null,null);}

    public User( String username, String password, String nickName) {
        Username = username;
        Password = password;
        Nickname = nickName;
        teamList = new ArrayList<>();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return Username;
    }

    public void setUsername(String userName) {
        Username = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickName) {
        Nickname = nickName;
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
                ", Nickname='" + Nickname + '\'' +
                '}';
    }
}

