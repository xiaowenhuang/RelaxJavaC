package com.sven.action.question;

import com.sven.model.QuestionBank;
import com.sven.model.User;
import com.sven.service.login.LoginService;
import com.sven.service.question.SetQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 出题控制层
 * Created by sven on 2016/11/3.
 */
@Controller
@RequestMapping("setAQuestion")
public class SetQuestionController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private SetQuestionService setQuestionService;

    //首页
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "question/setQuestionIndex";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String addNewQuestion(QuestionBank questionBank,HttpSession session){
        String account = (String)session.getAttribute("account");//获取当得登陆帐号
        User user = loginService.getUserInfo(account);
        String creator = user.getFirstName()+user.getLastName();
        Date date = new Date();
        questionBank.setCreator(creator);
        questionBank.setCreateTime(date);
        setQuestionService.addNewQuestion(questionBank);
        return "tips/addQuestionSuccess";
    }
}
