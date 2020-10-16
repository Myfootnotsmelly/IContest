package com.service;

import com.domain.User;

public interface ILogin {
    User Login(String username,String password);
}
