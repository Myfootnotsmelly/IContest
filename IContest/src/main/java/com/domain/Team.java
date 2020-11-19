package com.domain;

import com.domain.IUser.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Team{
    private Integer tid;

    private String teamName;

    private User captain;

    private String contestType;

    private String teamInfo;

    private List<User> members = new ArrayList<>();




    public Team() {
        this(null,null,null,null);
    }

    public Team(String teamName, User captain, String type, String teamInfo) {
        this.tid = -1;
        this.teamName = teamName;
        this.captain = captain;
        this.contestType = type;
        this.teamInfo = teamInfo;
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

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String type) {
        this.contestType = type;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(String teamInfo) {
        this.teamInfo = teamInfo;
    }

    public void notifyUser(User user,String comt)
    {
        Session session = new Session(null,user.getId(),teamName,user.getUserName(),comt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(tid, team.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid);
    }

    @Override
    public String toString() {
        return "Team{" +
                "tid=" + tid +
                ", teamName='" + teamName + '\'' +
                ", captain=" + captain +
                ", members=" + members +
                ", Type='" + contestType + '\'' +
                ", teamInfo='" + teamInfo + '\'' +
                '}';
    }
}
