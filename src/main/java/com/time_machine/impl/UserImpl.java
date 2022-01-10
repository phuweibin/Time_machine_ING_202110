package com.time_machine.impl;

import com.time_machine.dao.IUserDao;
import com.time_machine.pojo.User;
import com.time_machine.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component(value = "userImpl")
public class UserImpl implements IUserService {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    /**
     *
     * @param user which attributes should include userName and password
     * @return current user query from database using userName and password, null if userName or password is incorrect.
     */
    @Override
    public User userLogin(User user) {
        IUserDao  iUserDao = ctx.getBean(IUserDao.class);
        String userName = user.getUserName();
        String password = user.getPasswordMD5();
        user = iUserDao.getUser(userName,password);
        return user;
    }

    @Override
    public User userRegistry(User user) {
        IUserDao  iUserDao = ctx.getBean(IUserDao.class);
        User insertedUser = iUserDao.insertUser(user);
        return insertedUser;
    }

    @Override
    public void userDelete(User user) {
        IUserDao  iUserDao = ctx.getBean(IUserDao.class);
        iUserDao.deleteUser(user);
    }
}
