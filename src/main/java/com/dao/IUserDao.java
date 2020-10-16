package com.dao;

import com.domain.User;


import java.util.List;

public interface IUserDao {

     List<User> FindAll();

     List<User> FindByNickName(String name);

     /**
      * 根据条件查询
      * @param user：查询的条件，
      * @return
      */
     List<User> FindByCondition(User user);

     User FindById(int id);

     //String FindPswd(String Username);
     User FindWhenLogin(String username,String password);

     void saveUser(User user);

     void deleteUser(int uid);

     void updateUser(User user);
}
