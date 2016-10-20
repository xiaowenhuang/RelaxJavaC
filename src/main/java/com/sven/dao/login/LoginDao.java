package com.sven.dao.login;

import com.sven.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by sven on 2016/10/19.
 */
public interface LoginDao {
    public User getUserInfo(String userNum);
}
