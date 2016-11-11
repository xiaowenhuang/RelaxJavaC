package com.sven.dao.relax;

import com.sven.dao.BaseDao;
import com.sven.model.QuestionBank;
import org.springframework.stereotype.Repository;

/**
 * Created by sven on 2016/11/8.
 */
@Repository
public class RelaxDaoImpl extends BaseDao implements RelaxDao {
    @Override
    public QuestionBank getRnadomQuestion() {
        return this.getSqlSession().selectOne("questionBank.getRandomQuestion");
    }
}
