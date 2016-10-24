package com.sven.action.register;

import com.sven.model.User;
import com.sven.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "register/registerIndex";
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public String doRegister(User user){
        try {
            registerService.registerMember(user);
        }catch (Exception e){
            e.printStackTrace();
            return "FAILURE";
        }
        return "SUCCESS";
    }
}
