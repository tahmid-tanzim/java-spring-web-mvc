package com.born2code.spring.web.service;

import com.born2code.spring.web.dao.User;
import com.born2code.spring.web.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService {
    private UsersDao usersDao;

    @Autowired
    public void setNoticesDao(UsersDao noticesDao) {
        this.usersDao = noticesDao;
    }

    public void create(User user) {
        usersDao.create(user);
    }

    public boolean exists(String username) {
        return usersDao.exists(username);
    }
}
