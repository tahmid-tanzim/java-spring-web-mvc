package com.born2code.spring.web.controllers;

import com.born2code.spring.web.dao.FormValidationGroup;
import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
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

//    @ExceptionHandler(DataAccessException.class)
//    public String handleDatabaseException(DataAccessException ex){
//        return "error";
//    }

    @RequestMapping("/notices")
    public String showNotice(Model model) {
//        noticesService.throwTextException();
        List<Notice> notices = noticesService.getCurrent();
        model.addAttribute("notices", notices);
        return "notices";
    }

    @RequestMapping("/createnotice")
    public String createNotice(Model model, Principal principal) {

        Notice notice = null;
        if (principal != null) {
            String username = principal.getName();
            notice = noticesService.getNotice(username);
        }

        if (notice == null) {
            notice = new Notice();
        }

        model.addAttribute(notice);
        return "createnotice";
    }

    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public String doCreate(Model model, @Validated(value = FormValidationGroup.class) Notice notice, BindingResult bindingResult, Principal principal, @RequestParam(value = "delete", required = false) String delete) {
        if (bindingResult.hasErrors()) {
            return "createnotice";
        }

        if (delete == null) {
            /* Save or Update */
            String username = principal.getName();
            notice.getUser().setUsername(username);
            noticesService.createOrUpdate(notice);
            return "noticecreated";
        } else {
            /* Delete */
            noticesService.delete(notice.getId());
            return "noticedeleted";
        }

    }
}
