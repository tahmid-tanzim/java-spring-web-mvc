package com.born2code.spring.web.controllers;

import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;


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
    public String createNotice(Model model) {
        model.addAttribute(new Notice());
        return "createnotice";
    }

    @RequestMapping(value="/docreate", method = RequestMethod.POST)
    public String doCreate(Model model, @Valid Notice notice, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError err : errors) {
                System.out.print(err.getDefaultMessage());
            }
            return "createnotice";
        }
        return "noticecreated";
    }
}
