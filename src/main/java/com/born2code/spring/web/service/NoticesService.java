package com.born2code.spring.web.service;

import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.dao.NoticesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticesService")
public class NoticesService {
    private NoticesDao noticesDao;

    @Autowired
    public void setNoticesDao(NoticesDao noticesDao) {
        this.noticesDao = noticesDao;
    }

    public List<Notice> getCurrent() {
        return noticesDao.getNotices();
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public void create(Notice notice) {
        noticesDao.create(notice);
    }

    public boolean hasNotice(String name) {
        if(name == null)
            return false;

        List<Notice> notices = noticesDao.getNotices(name);
        if(notices.size() == 0)
            return false;

        return true;
    }
}
