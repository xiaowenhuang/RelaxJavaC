package com.sven.service.login;

import com.sven.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by sven on 2016/10/19.
 */

public interface LoginService {
    public User getUserInfo(String account);
}
