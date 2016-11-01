package com.sven.action.login;

/**
 * 登陆控制类
 * Created by sven on 2016/10/19.
 */

import com.sven.model.User;
import com.sven.service.login.LoginService;
import com.sven.util.CaptchaUtil;
import com.sven.util.wechat.XPFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = "loginPost",method = RequestMethod.POST)
    @ResponseBody
    public String loginPost(User user,HttpServletRequest request ,HttpSession session)
            throws ServletException, IOException {
        String validateCode = request.getParameter("validateCode");
        boolean validateResult = validateCode(validateCode,request);
        if(!validateResult){
            return "VALIDATECODE";
        }
        String account = user.getAccount();
        String passwd = user.getPasswd();
        passwd = XPFunctions.saltMD5(passwd);
        User users = loginService.getUserInfo(account);
        if(users != null && users.getPasswd().equals(passwd)){
            System.out.println("登陆成功");
            session.setAttribute("account", account);
            return "SUCCESS";
        }else if(users != null && !users.getPasswd().equals(passwd)){
            System.out.println("登陆失败,密码不正确");
            return "FALSEPASSWORD";
        }
        else{
            System.out.println("登陆失败");
            return "FAIL";
        }
    }

    /**
     * 输入的校验码是否正确
     * @param validateCode 校验码
     * @param request 请求
     * @return 返回true or false
     */
    private boolean validateCode(String validateCode,HttpServletRequest request) {
        Object randomString = request.getSession().getAttribute("randomString");
        return validateCode.toUpperCase().equals(randomString);
    }
}
