package com.sven.dao.login;

import com.sven.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by sven on 2016/10/19.
 */
@Repository
public class LoginDaoImpl implements LoginDao {
    @Override
    public User getUserInfo(String userNum) {
        System.out.println("暂时测试");
        return null;
    }
}
