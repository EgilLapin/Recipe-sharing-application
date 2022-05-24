package com.recipesharingapp.Recipesharingapplication.service;

import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    public User fetchUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void deleteUserById(Long userId) {
         userRepository.deleteById(userId);
    }

}
