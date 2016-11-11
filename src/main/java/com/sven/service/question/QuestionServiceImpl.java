package com.sven.service.question;

import com.sven.dao.question.QuestionDao;
import com.sven.model.QuestionBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sven on 2016/11/3.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Override
    public List<QuestionBank> getAllQuestions() {
        return questionDao.getAllQuestions();
    }
}
