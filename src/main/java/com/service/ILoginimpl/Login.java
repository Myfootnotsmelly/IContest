package com.service.ILoginimpl;

import com.dao.IUserDao;
import com.domain.User;
import com.service.ILogin;
import org.springframework.beans.factory.annotation.Autowired;

public class Login implements ILogin {

    @Autowired
    private IUserDao userDao;

    @Override
    public User Login(String username,String passward) {
        return userDao.FindWhenLogin(username,passward);
    }
}
