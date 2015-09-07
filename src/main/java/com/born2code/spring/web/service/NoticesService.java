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
    public void createOrUpdate(Notice notice) {
//        if (notice.getId() != 0) {
//            noticesDao.update(notice);
//        } else {
//            noticesDao.create(notice);
//        }

        noticesDao.saveOrUpdate(notice);
    }

    public boolean hasNotice(String name) {
        if (name == null)
            return false;

        List<Notice> notices = noticesDao.getNotices(name);
        if (notices.size() == 0)
            return false;

        return true;
    }

    public Notice getNotice(String username) {

        if (username == null)
            return null;

        List<Notice> notices = noticesDao.getNotices(username);

        if (notices.size() == 0)
            return null;

        return notices.get(0);
    }

    public void delete(int id) {
        noticesDao.delete(id);
    }
}
