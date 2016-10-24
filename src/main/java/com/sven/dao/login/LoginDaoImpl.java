package com.sven.dao.login;

import com.sven.dao.BaseDao;
import com.sven.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by sven on 2016/10/19.
 */
@Repository
public class LoginDaoImpl extends BaseDao implements LoginDao {
    @Override
    public User getUserInfo(String account) {
        return this.getSqlSession().selectOne("user.queryUser",account);
    }
}
