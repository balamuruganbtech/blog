package com.blog.service;

public interface UserService {
    boolean authenticate(String username, String password);

    void register(String username, String password);
}