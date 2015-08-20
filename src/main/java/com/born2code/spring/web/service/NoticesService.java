package com.born2code.spring.web.service;

import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.dao.NoticesDao;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void create(Notice notice) {
        noticesDao.create(notice);
    }
}
