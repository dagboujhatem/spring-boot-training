package com.fivepoints.spring.controllers;

import com.fivepoints.spring.entities.User;
import com.fivepoints.spring.response.MessageResponse;
import com.fivepoints.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    // Dependency Injection
    @Autowired
    UserService userService;

    // Get all users
    @GetMapping(path = "/users")
    public List<User> getAllUsers()
    {
        return this.userService.getAllUsers();
    }
    // Get one user by ID
    @GetMapping(path = "/users/{id}")
    public User getUserByID(@PathVariable int id)
    {
        return this.userService.getUserByID(id);
    }

    // create new user in the database
    @PostMapping(path = "/users")
    public User addNewUser(@RequestBody User user)
    {
        return this.userService.addNewUser(user);
    }

    // update user by ID
    @PutMapping(path = "/users/{id}")
    public MessageResponse updateUserById(@PathVariable int id, @RequestBody User user)
    {
        return this.userService.updateUserById(id, user);
    }

    @DeleteMapping(path = "/users/{id}")
    public MessageResponse deleteUserById(@PathVariable int id)
    {
        return this.userService.deleteUserById(id);
    }
}
