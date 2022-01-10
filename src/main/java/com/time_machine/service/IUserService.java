package com.time_machine.service;

import com.time_machine.pojo.User;

public interface IUserService {
    /**
     * 用户登录验证
     * @param user 用户
     * @return 用户POJO
     */
    public User userLogin(User user);
    public User userRegistry(User user);
    public void userDelete(User user);
}
