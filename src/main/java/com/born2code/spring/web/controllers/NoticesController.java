package com.born2code.spring.web.controllers;

import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    /* Getting URL Parameter */
    @RequestMapping("/test")
    public String showTest(@RequestParam("id") String identification) {
        System.out.print("Id is: " + identification);
        return "notices";
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

    @RequestMapping(value="/docreate", method = RequestMethod.POST)
    public String doCreate(Model model, Notice notice) {
        System.out.print(notice);
        return "noticecreated";
    }
}
