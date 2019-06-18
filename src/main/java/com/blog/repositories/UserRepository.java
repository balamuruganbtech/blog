package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.User;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {

    public User findByUsernameAndPasswordHash(String username, String password);
}
