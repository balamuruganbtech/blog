package com.blog.service;

import java.util.List;

import com.blog.entity.Post;

public interface PostService {
    List<Post> findAll();


    Post create(Post post);

}
