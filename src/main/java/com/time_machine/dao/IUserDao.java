package com.time_machine.dao;
import com.time_machine.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {
    public User getUser(@Param("userName") String userName,@Param("password") String password);
    public User insertUser(User user);
    public void deleteUser(User user);
}
