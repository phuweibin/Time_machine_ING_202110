package com.time_machine.controller;

import com.time_machine.impl.UserImpl;
import com.time_machine.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller("loginControl")
@RequestMapping("/login")
public class LoginControl {
    static Logger logger = Logger.getLogger(LoginControl.class.getName());
    //control类实现: 1. 获取请求参数，2. 处理业务逻辑，3. 绑定模型和视图
    //注入用户实现类
    @Autowired
    private UserImpl userService = null;
    @RequestMapping(value = "/login.do")
    @ResponseBody
    public User loginCheck(Model model, @RequestBody User user, HttpSession session){
        logger.info("user:"+user.toString());
        user = userService.userLogin(user);
        if(user == null){
            logger.info("user is null");
        }else{
            logger.info("return user:"+user.toString());
            model.addAttribute("user",user);
        }
        session.setAttribute("user",user);
        return user;
    }

    @RequestMapping("/logout.do")
    @ResponseBody
    public User logout(Model model,@SessionAttribute("user") User user, HttpSession session){
        if(user != null){
            logger.info("logout:"+user.getUserName());
        }
        session.setAttribute("user",null);
        return user;
    }
}
