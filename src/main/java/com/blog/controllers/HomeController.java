package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.service.NotificationService;
import com.blog.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/")
    public String home(Model model, HttpSession session) {

        if ((User) session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("logged", true);
        model.addAttribute("user", ((User) ((User) session.getAttribute("user"))).getUsername());

        return "index";
    }

//    @RequestMapping("/posts/view/{id}")
//    public String view(@PathVariable("id") Long id,
//                       Model model) {
//        Post post = postService.findById(id);
//
//        if (post == null) {
//            notificationService.addErrorMessage(
//                    "Cannot find post: " + id);
//            return "redirect:/";
//        }
//
//        model.addAttribute("post", post);
//        return "/posts/index";
//    }

}