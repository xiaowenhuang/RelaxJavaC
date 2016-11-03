package com.sven.dao.question;

import com.sven.model.QuestionBank;

import java.util.List;

/**
 * Created by sven on 2016/11/3.
 */
public interface QuestionDao {
    public List<QuestionBank> getAllQuestions();
}
