package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.forms.PostForm;
import com.blog.service.NotificationService;
import com.blog.service.PostService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PostCreationController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/users/createpost")
    public String register(PostForm postForm) {
        return "users/createpost";
    }

    @RequestMapping(value = "/users/createpost", method = RequestMethod.POST)
    public String registrationPage(@Valid PostForm postForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/createpost";
        }


        postService.create(
                new Post(postForm.getTitle(), postForm.getBody(), ((User) httpSession.getAttribute("user"))));


        notifyService.addInfoMessage("Post added successful");
        return "redirect:/";
    }
}