package com.born2code.spring.web.controllers;

import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
public class NoticesController {

    private NoticesService noticesService;

    @Autowired
    public void setNoticesService(NoticesService noticesService) {
        this.noticesService = noticesService;
    }

    @RequestMapping("/notices")
    public String showNotice(Model model) {
        List<Notice> notices = noticesService.getCurrent();
        model.addAttribute("notices", notices);
        return "notices";
    }

    @RequestMapping("/createnotice")
    public String createNotice() {
        return "createnotice";
    }
}
