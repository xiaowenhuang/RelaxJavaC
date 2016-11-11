package com.sven.service.relax;

import com.sven.dao.relax.RelaxDao;
import com.sven.model.QuestionBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sven on 2016/11/8.
 */
@Service
public class RelaxServiceImpl implements RelaxService {
    @Autowired
    private RelaxDao relaxDao;

    /**
     * 获取随机题目
     * @return
     */
    @Override
    public QuestionBank getRnadomQuestion() {
        return relaxDao.getRnadomQuestion();
    }
}
