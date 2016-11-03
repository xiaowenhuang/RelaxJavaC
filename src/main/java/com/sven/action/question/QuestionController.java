package com.sven.action.question;

import com.sven.model.QuestionBank;
import com.sven.service.login.LoginService;
import com.sven.service.question.QuestionService;
import com.sven.service.question.SetQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by sven on 2016/11/3.
 */
@Controller
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping("index")
    public String index(Model model){
        List<QuestionBank> questionList =  questionService.getAllQuestions();
        model.addAttribute("questionList",questionList);
        return "question/allQuestions";
    }
}
