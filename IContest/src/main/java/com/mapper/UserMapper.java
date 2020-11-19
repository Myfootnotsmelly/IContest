package com.mapper;

import com.domain.IUser.User;
import com.domain.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

     List<User> FindAll();

     List<User> FindByNickName(String name);

     /**
      * 根据条件查询
      * @param user：查询的条件，
      * @return
      */
     List<User> FindByCondition(User user);

     //计算用户名数量，用于注册时保证用户名的唯一性
     Integer Count_username(String name);

     User FindById(int id);

     User FindWhenLogin(String username,String password);

     /**
      * 注册
      * @param user
      * @return
      */
     void saveUser(@Param("user")User user);

     void deleteUser(int id);

     void updateUser(User user);

     List<Team> FindTeams(int uid);
}
