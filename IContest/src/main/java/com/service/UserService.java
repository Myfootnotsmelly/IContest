package com.service;

import com.mapper.UserMapper;
import com.domain.IUser.User;
import com.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public void setUserDao(UserMapper userDao) {
        this.userDao = userDao;
    }

    public List<User> FindAll(){return userDao.FindAll();};

    //用户注册
    //TODO 用户名不满足唯一性时返回包含错误码的JSON格式信息
    public User UserRegist(User user){
        if(userDao.Count_username(user.getUserName())==0) {
            userDao.saveUser(user);
            return user;
        }
        else
        {
            return null;
        }
    }

    //用户登陆
    public User UserLogin(String username,String password){
        return userDao.FindWhenLogin(username,password);
    }

    //模糊搜索
    public List<User>FindByNickName(String name){return userDao.FindByNickName(name);}

    public User FindById(int id){return userDao.FindById(id);}

    public void updateUser(User user){userDao.updateUser(user);}

    public void deleteUser(int id){userDao.deleteUser(id);}

    public List<Team> FindTeams(int id){return userDao.FindTeams(id);}
}
