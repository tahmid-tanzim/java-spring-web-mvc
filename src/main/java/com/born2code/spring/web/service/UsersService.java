package com.born2code.spring.web.service;

import com.born2code.spring.web.dao.Message;
import com.born2code.spring.web.dao.MessagesDao;
import com.born2code.spring.web.dao.User;
import com.born2code.spring.web.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersService")
public class UsersService {
    @Autowired
    private UsersDao usersDao;

    @Autowired
    private MessagesDao messagesDao;

    public void create(User user) {
        usersDao.create(user);
    }

    public boolean exists(String username) {
        return usersDao.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }

    public void sendMessage(Message message) {
        System.out.print(message);
        messagesDao.saveOrUpdate(message);
    }

    public User getUser(String username) {
        return usersDao.getUser(username);
    }
}
