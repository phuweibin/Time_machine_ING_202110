package com.time_machine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("indexControl")
@RequestMapping("/index")
public class IndexControl {
    @RequestMapping("/index.do")
    public String returnIndex(){
        return "index";
    }
    @RequestMapping("/index.html")
    public String forwardToIndex(){
        return "index";
    }
}
