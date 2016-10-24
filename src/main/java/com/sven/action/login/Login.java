package com.sven.action.login;

/**
 * Created by sven on 2016/10/19.
 */

import com.sven.model.User;
import com.sven.service.login.LoginService;
import com.sven.util.CaptchaUtil;
import com.sven.util.XPFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class Login {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/index")
    public String index(){
        return "login/loginIndex";
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
    @ResponseBody
    public String loginPost(User user,HttpServletRequest request){
        String validateCode = request.getParameter("validateCode");
        boolean validateResult = validateCode(validateCode,request);
        if(!validateResult){
            return "Fail";
        }
        String account = user.getAccount();
        String passwd = user.getPasswd();
        passwd = XPFunctions.saltMD5(passwd);
        User users = loginService.getUserInfo(account);
        if(users != null && users.getPasswd().equals(passwd)){
            System.out.println("登陆成功");
            return("SUCCESS");
        }
        else{
            System.out.println("登陆失败");
            return("FAILsdaafadsffa");

        }
    }

    /**
     * 输入的校验码是否正确
     * @param validateCode
     * @param request
     * @return
     */
    private boolean validateCode(String validateCode,HttpServletRequest request) {
        Object randomString = request.getSession().getAttribute("randomString");
        if(validateCode.toUpperCase().equals(randomString)){
            return true;
        }else{
            return false;
        }
    }
}
