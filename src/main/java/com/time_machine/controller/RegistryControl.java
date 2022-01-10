package com.time_machine.controller;

import com.time_machine.pojo.User;
import com.time_machine.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registry")
public class RegistryControl {
    static Logger logger = Logger.getLogger(LoginControl.class.getName());

    @Autowired
    IUserService userService = null;

    @ResponseBody
    @RequestMapping("/verifyNumber.do")
    public String getVerifyNumber(@RequestParam String phoneNumber){
        logger.info("phoneNumber:"+phoneNumber);
        return "\"verifyNumber\":\"1234\"";
    }

    @RequestMapping("/registry.do")
    @ResponseBody
    public User Registry(@RequestBody User user){
       User registriedUser =  userService.userRegistry(user);
       if(registriedUser!= null){
           logger.info("注册成功："+registriedUser.toString());
       }else{
           logger.info("注册失败");
       }
       return registriedUser;
    }

}
