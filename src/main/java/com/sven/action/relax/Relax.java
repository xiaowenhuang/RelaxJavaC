package com.sven.action.relax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 本应用的主页
 *
 * Created by sven on 2016/10/26.
 */
@Controller
@RequestMapping("relax")
public class Relax {
    @RequestMapping(value="index",method = RequestMethod.GET)
    public String index(){
        return "relax/relaxIndex";
    }
}
