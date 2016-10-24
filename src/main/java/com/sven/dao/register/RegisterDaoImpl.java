package com.sven.dao.register;

import com.sven.dao.BaseDao;
import com.sven.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by sven on 2016/10/21.
 */
@Repository
public class RegisterDaoImpl extends BaseDao implements RegisterDao {
    @Override
    public void registerMember(User user) {
        this.getSqlSession().insert("user.addUser",user);
    }
}
