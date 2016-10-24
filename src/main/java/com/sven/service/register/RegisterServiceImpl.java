package com.sven.service.register;

import com.sven.dao.register.RegisterDao;
import com.sven.model.User;
import com.sven.util.XPFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sven on 2016/10/21.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;
    @Override
    public void registerMember(User user) {
        //将明文密码变密文
        String passwd = user.getPasswd();
        user.setPasswd(XPFunctions.saltMD5(passwd));

        registerDao.registerMember(user);
    }
}
