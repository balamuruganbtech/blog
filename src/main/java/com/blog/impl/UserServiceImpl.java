package com.blog.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.User;
import com.blog.repositories.UserRepository;
import com.blog.service.UserService;
import com.blog.utils.PasswordHasher;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    HttpSession session;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        password = PasswordHasher.hash(password);
        User user = userRepository.findByUsernameAndPasswordHash(username, password);
        if (user == null)
            return false;
        else {
            session.setAttribute("user", user);

            return true;
        }
    }

    @Override
    public void register(String username, String password) {
        User user = new User();
        password = PasswordHasher.hash(password);
        user.setUsername(username);
        user.setPasswordHash(password);
        userRepository.save(user);
        session.setAttribute("user", user);
    }
}