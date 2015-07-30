package com.born2code.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.String;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHome() {
        return "home";
    }
}
