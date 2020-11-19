package com.mapper;

import com.domain.IUser.User;
import com.domain.Team;
import com.service.TeamService;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TeamMapperTest {
    @Autowired
    private TeamService teamService;


    @Test
    public void Testfindall()
    {
        List<Team> teams= teamService.FindAll();
        if(!teams.isEmpty())
        {
            for(Team team:teams)
            {
                System.out.println(team);
            }
        }
    }

    @Test
    public void TestSaveTeam()
    {
        User u = new User();
        u.setId(30);
        Team t = new Team("哈哈队",u,"SOme","ccc");
        teamService.saveTeam(t);
    }

    @Test
    public void TestDeleteTeam()
    {
        teamService.deleteTeam(3);
    }

    @Test
    public void TestFindByType()
    {
        List<Team> t = teamService.FindByType("冲");
        for(Team team :t )
        {
            System.out.println(team);
        }
    }

    @Test
    public void TestFindByName()
    {
        List<Team> t = teamService.FindByName("C");
        for(Team team :t )
        {
            System.out.println(team);
        }
    }

    @Test
    public void Testfindbyid()
    {
        System.out.println(teamService.FindById(1));
    }


    @Test
    public void Test_update()
    {
        Team team = new Team();
        User user = new User();
        user.setId(28);
        team.setTeamInfo("森林");
        team.setCaptain(user);
        team.setTid(1);
        teamService.updateTeam(team);
    }

    @Test
    public void Test_addmember()
    {
        teamService.addMember(1,33);
    }

    @Test
    public void Test_deletemember()
    {
        teamService.deleteMember(1,33);
    }

    @Test
    public void Test_Findallmembers()
    {
        List<User> users =teamService.FindAllMembers(1);
        for(User u:users){
            System.out.println(u);
        }
    }

    @Test
    public void Test_saveTeam()
    {
        User u = new User();
        u.setId(33);
        Team t = new Team("Last",u,null,null);
        teamService.saveTeam(t);
    }

    @Test
    public void Test_FindByCaptainId()
    {
        List<Team> teams = teamService.FindByCaptainId(33);
        for(Team t:teams){
            System.out.println(t);
        }
    }


}