package com.born2code.spring.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.String;

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    public String showHome() {
        logger.info("Showing home ...");
        return "home";
    }
}
