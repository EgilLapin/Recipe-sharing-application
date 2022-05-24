package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userservice;

    //- Create user
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
       return userservice.createUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUserList(){
        return userservice.fetchUserList();
    }

    //- Get user by id
    @GetMapping("/users/{id}")
    public User fetchUserById(@PathVariable("id") Long userId){
        return userservice.fetchUserById(userId);
    }

    //- Delete user by id
    @DeleteMapping("users/{id}")
    public String deleteUserById(@PathVariable("id") Long userId){
        userservice.deleteUserById(userId);
        return "User Deleted!";
    }
}
