package com.sven.dao.question;

import com.sven.dao.BaseDao;
import com.sven.model.QuestionBank;
import org.springframework.stereotype.Service;

/**
 * Created by sven on 2016/11/3.
 */
@Service
public class SetQuestionDaoImpl extends BaseDao implements SetQuestionDao  {
    @Override
    public void addNewQuestion(QuestionBank questionBank) {
        this.getSqlSession().insert("questionBank.addQuestion",questionBank);
    }
}
