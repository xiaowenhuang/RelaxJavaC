package com.sven.service.question;

import com.sven.dao.question.SetQuestionDao;
import com.sven.model.QuestionBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sven on 2016/11/3.
 */
@Service
public class SetQuestionServiceImpl implements SetQuestionService {
    @Autowired
    private SetQuestionDao setQuestionDao;
    @Override
    public void addNewQuestion(QuestionBank questionBank) {
        setQuestionDao.addNewQuestion(questionBank);
    }
}
