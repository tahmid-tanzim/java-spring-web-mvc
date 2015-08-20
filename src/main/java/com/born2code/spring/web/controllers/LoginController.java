package com.born2code.spring.web.controllers;

import com.born2code.spring.web.dao.User;
import com.born2code.spring.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping("/signout")
    public String showSignout() {
        return "logout";
    }

    @RequestMapping("/newaccount")
    public String showNewAccount(Model model) {
        model.addAttribute("user", new User());
        return "newaccount";
    }

    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String doCreate(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newaccount";
        }

        if (usersService.exists(user.getUsername())) {
            bindingResult.rejectValue("username", "DuplicateKey.user.username", "This username already exists. Please choose another username.");
            return "newaccount";
        }

        user.setAuthority("user");
        user.setEnabled(true);
        try {
            usersService.create(user);
        } catch (DuplicateKeyException ex) {
            bindingResult.rejectValue("username", "DuplicateKey.user.username", "This username already exists. Please choose another username.");
            return "newaccount";
        }
        return "accountcreated";
    }

    @RequestMapping("/admin")
    public String showAdmin(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }
}
