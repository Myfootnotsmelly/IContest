package com.domain;

import java.util.ArrayList;
import java.util.List;


public class Team {
    private Integer tid;

    private String teamName;

    private User captain;

    private String type;

    private String teamInfo;

    private List<User> members = new ArrayList<>();


    public Team() {
        this(null,null,null,null);
    }

    public Team(String teamName, User captain, String type, String teamInfo) {
        this.tid = -1;
        this.teamName = teamName;
        this.captain = captain;
        this.type = type;
        this.teamInfo = teamInfo;
        this.members.add(captain);
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public User getCaptain() {
        return captain;
    }

    public void setCaptain(User captain) {
        this.captain = captain;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(String teamInfo) {
        this.teamInfo = teamInfo;
    }

    @Override
    public String toString() {
        return "Team{" +
                "tid=" + tid +
                ", teamName='" + teamName + '\'' +
                ", captain=" + captain +
                ", members=" + members +
                ", teamShortInfo='" + type + '\'' +
                ", teamInfo='" + teamInfo + '\'' +
                '}';
    }
}
