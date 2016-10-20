package com.sven.service.login;

import com.sven.dao.login.LoginDao;
import com.sven.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sven on 2016/10/19.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public User getUserInfo(String userNum) {
        return loginDao.getUserInfo(userNum);
    }
}
