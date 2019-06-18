package com.blog.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.repositories.PostRepository;
import com.blog.service.PostService;

@Service
@Primary
public class PostServiceImpl implements PostService {

    @Autowired
    HttpSession httpSession;

    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findByAuthorId((((User) httpSession.getAttribute("user")).getId()));
    }


    @Override
    public Post create(Post post) {
        return postRepo.save(post);
    }


}
