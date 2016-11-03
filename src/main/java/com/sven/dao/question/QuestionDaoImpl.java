package com.sven.dao.question;

import com.sven.dao.BaseDao;
import com.sven.model.QuestionBank;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sven on 2016/11/3.
 */
@Repository
public class QuestionDaoImpl extends BaseDao implements QuestionDao {
    @Override
    public List<QuestionBank> getAllQuestions() {
        return this.getSqlSession().selectList("questionBank.getAllQuestions");
    }
}
