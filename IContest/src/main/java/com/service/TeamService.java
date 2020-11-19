package com.service;

import com.mapper.TeamMapper;
import com.domain.Team;
import com.domain.IUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 队伍管理业务
 */
@Service
public class TeamService {

    @Autowired
    private TeamMapper teamDao;

    public void setTeamDao( TeamMapper teamDao) {
        this.teamDao = teamDao;
    }



    public List<Team> FindAll(){
        List<Team> teams = teamDao.FindAll();
        for(Team t:teams){
            t.setMembers(teamDao.FindAllMembers(t.getTid()));
        }
        return teams;
    }

    public void saveTeam(Team team){
        teamDao.saveTeam(team);
        teamDao.addMember(team.getTid(),team.getCaptain().getId());
    }

    public void deleteTeam(int id){teamDao.deleteTeam(id);}

    public void updateTeam(Team team){teamDao.updateTeam(team);}

    public List<Team> FindByType(String type){return teamDao.FindByType(type);}

    public List<Team> FindByName(String name){return teamDao.FindByName(name);}

    public List<Team> FindByUserId(int uid){
        List<Team> teams = teamDao.FindByUserId(uid);
        for(Team t:teams){
            t.setMembers(FindAllMembers(t.getTid()));
        }
        return teams;
    }

    public List<Team> FindByCaptainId(int id){
        return teamDao.FindByCaptainId(id);
    }

    public Team FindById(int tid){return teamDao.FindById(tid);}

    public void addMember(int tid,int uid){teamDao.addMember(tid,uid);}

    public void deleteMember(int tid,int uid){teamDao.deleteMember(tid,uid);}

    public List<User> FindAllMembers(int tid){return teamDao.FindAllMembers(tid);}
}
