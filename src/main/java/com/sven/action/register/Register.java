package com.sven.action.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注册类
 * Created by sven on 2016/10/20.
 */
@RequestMapping("/register")
@Controller
public class Register {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "register/registerIndex";
    }
    @RequestMapping("/doRegister")
    @ResponseBody
    public String doRegister(){

        return "注册成功";
    }
}