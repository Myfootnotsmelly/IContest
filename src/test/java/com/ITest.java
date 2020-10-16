package com;

import com.dao.IUserDao;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ITest {

    private SqlSession session;
    private InputStream in;
    private IUserDao accountDao;

    @Before
    public void init() throws Exception
    {
        in = Resources.getResourceAsStream("MysqlConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        accountDao = session.getMapper(IUserDao.class);
    }

    @After
    public void end() throws Exception
    {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void FindAllTest() throws  Exception{

        List<User> users =  accountDao.FindAll();
        for(User user:users)
            System.out.println(user);

    }

    @Test
    public void saveTest()
    {
        User u = new User();
        u.setId(5);
        u.setNickName("lz");
        u.setPassword("123");
        u.setUserName("LZ");
        accountDao.saveUser(u);
    }

    @Test
    public void FindByNameTest()
    {
        List<User> users= accountDao.FindByNickName("%王%");
        if(!users.isEmpty())
        {
            for(User user:users)
            {
                System.out.println(user);
            }
        }
    }

    @Test
    public void FindByConditionTest()
    {
        User u = new User();
        u.setUserName("王%");
        List<User> users = accountDao.FindByCondition(u);
        for(User user:users)
        {
            System.out.println(user);
        }
    }
}
