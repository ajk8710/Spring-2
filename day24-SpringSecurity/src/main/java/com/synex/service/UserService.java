package com.synex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.synex.domain.User;

@Service
public interface UserService {

    public User save(User user);
    public User findByUserId(long userId);
    public List<User> findAll();
    public void deleteUserById(long userId);
    
    public User findByUserName(String userName);
    boolean existById(long userId);
    
}
