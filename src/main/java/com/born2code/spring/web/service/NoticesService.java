package com.born2code.spring.web.service;

import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.dao.NoticesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticesService")
public class NoticesService {
    private NoticesDAO noticesDAO;

    @Autowired
    public void setNoticesDAO(NoticesDAO noticesDAO) {
        this.noticesDAO = noticesDAO;
    }

    public List<Notice> getCurrent() {
        return noticesDAO.getNotices();
    }

    public void create(Notice notice) {
        noticesDAO.create(notice);
    }

    public void throwTextException() {
        noticesDAO.getNotice(4569);
    }
}
