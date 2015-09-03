package com.born2code.spring.web.controllers;

import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.service.NoticesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.String;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private NoticesService noticesService;

    @RequestMapping("/")
    public String showHome(Model model, Principal principal) {
        logger.info("Showing home ...");
        List<Notice> notices = noticesService.getCurrent();
        model.addAttribute("notices", notices);

        boolean hasNotice = false;
        if(principal != null) {
            hasNotice = noticesService.hasNotice(principal.getName());
        }

        model.addAttribute("hasNotices", hasNotice);

        return "home";
    }
}
