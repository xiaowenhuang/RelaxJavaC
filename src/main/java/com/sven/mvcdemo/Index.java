package com.sven.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sven on 2016/10/19.
 */
@Controller
@RequestMapping("index")
public class Index  {
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String index(){
        return "home";
    }
}
