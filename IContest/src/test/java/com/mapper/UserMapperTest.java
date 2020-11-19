package com.mapper;

import com.domain.IUser.User;
import com.domain.Team;
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
public class UserMapperTest {
    @Autowired
    private UserService userService;

    @Test
    public void Test_id()
    {
        System.out.println(userService.FindById(28));
    }

    @Test
    public void Test_Login()
    {
        System.out.println(userService.UserLogin("admin","123"));
    }

    @Test
    public void Test_Save()
    {
        User u = new User();
        u.setUsername("Wininin");
        u.setNickname("winwinwin");
        System.out.println(userService.UserRegist(u));
    }

    @Test
    public void Test_findteams()
    {
        List<Team> teams =userService.FindTeams(28);
        for(Team t:teams){
            System.out.println(t);
        }
    }
}