package com.born2code.spring.web.controllers;

import com.born2code.spring.web.dao.Notice;
import com.born2code.spring.web.dao.User;
import com.born2code.spring.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/newaccount")
    public String showNewAccount(Model model) {
        model.addAttribute("user", new User());
        return "newaccount";
    }

    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String doCreate(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createaccount";
        }
        user.setAuthority("user");
        user.setEnabled(true);
        usersService.create(user);
        return "accountcreated";
    }
}
