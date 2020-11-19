package com.mapper;

import com.domain.IUser.User;
import com.domain.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamMapper {

    List<Team> FindAll();

    Team FindById(int id);

    List<Team> FindByUserId(int id);

    List<Team> FindByType(String type);

    List<Team> FindByName(String name);

    List<Team> FindByCaptainId(int id);

    void saveTeam(Team team);

    void updateTeam(Team team);

    void deleteTeam(int id);

    //人员操作
    void addMember(@Param("tid")int tid,@Param("uid")int uid);

    void deleteMember(@Param("tid")int tid,@Param("uid")int uid);

    List<User>FindAllMembers(int tid);

}
