package com.service;

import com.dao.IUserDao;
import com.domain.Team;
import com.domain.User;

/**
 * 队伍管理业务
 */
public class TeamService {

    private Team team;
    private IUserDao userDao;

    /**
     * 解散队伍
     */
    public void Dismiss(){}

    /**
     * 队员添加
     * @param users：可变参数，添加的user对象
     */
    public void addUser(User...users){}

    /**
     * 队员删除
     * @param users：可变参数，删除的user对象
     */
    public void deleteUser(User...users){}

    /**
     * 设置队长
     * @param user：队长
     */
    public void setCaptain(User user){}

    /**
     * 设置队伍的Info属性
     * @param info
     */
    public void setInfo(String info){}

}
