package com.sven.action.login;

/**
 * Created by sven on 2016/10/19.
 */

import com.sven.util.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class LoginIndex {
    @RequestMapping("/index")
    public String index(){
        return "login/index";
    }

    /**
     * 验证码
     */
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException,IOException{
        CaptchaUtil.outputCaptcha(req, resp);
    }

    /**
     * 提交登陆
     */
    @RequestMapping("/loginPost")
    public void loginPost(){
        //boolean validate = validateCaptcha("validateCode");

 /*       if(!validate){
            renderText("FAIL");
            return ;
        }*/

        String userNum = ("userNum");
        String userPsw = getPara("userPsw");
        userPsw = XPFunctions.saltMD5(userPsw);

        WebUser user = WebUser.dao.singleUserByUserNum(userNum);
        if(user != null && user.getUserPsw().equals(userPsw)){
            WebUser.initUserInfoIntoSession(user,getSession());
            String clientIp = XPNet.getClientIp(getRequest());
            WebAccessLog.dao.addLog(clientIp, user.getInt("userId"));
            renderText("SUCCESS");
        }
        else{
            renderText("FAIL");
        }
    }
}
