package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.forms.LoginForm;
import com.blog.service.NotificationService;
import com.blog.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    HttpSession session;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }

        if (!userService.authenticate(
                loginForm.getUsername(), loginForm.getPassword())) {
            notifyService.addErrorMessage("Invalid login!");
            return "users/login";
        }

        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }

    @RequestMapping(value = "/users/logout", method = RequestMethod.GET)
    public String logout() {

        session.setAttribute("user", null);
        notifyService.addInfoMessage("Logged out");
        return "redirect:/";
    }
}