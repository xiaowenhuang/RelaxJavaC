package com.sven.action.relax;

import com.sven.model.QuestionBank;
import com.sven.service.relax.RelaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 本应用的主页
 *
 * Created by sven on 2016/10/26.
 */
@Controller
@RequestMapping("relax")
public class RelaxController {
    @Autowired
    private RelaxService relaxService;
    @RequestMapping(value="index",method = RequestMethod.GET)
    public String index(Model model){
        QuestionBank questionBank = relaxService.getRnadomQuestion();
        model.addAttribute(questionBank);
        return "relax/relaxIndex";
    }
}
