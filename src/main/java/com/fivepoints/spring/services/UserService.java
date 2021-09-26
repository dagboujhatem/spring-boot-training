package com.fivepoints.spring.services;

import com.fivepoints.spring.entities.User;
import com.fivepoints.spring.repositories.UserRepository;
import com.fivepoints.spring.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    // Dependency Injection
    @Autowired
    UserRepository userRepository;

    // getAllUsers method
    public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }

    // getUserByID method
    public User getUserByID(int id)
    {
        return this.userRepository.findById(id).orElse(null);
    }

    // addNewUser method
    public User addNewUser(User user)
    {
        return this.userRepository.save(user);
    }

    // updateUserById method
    public MessageResponse updateUserById(int id, User user)
    {
        User userFound = this.userRepository.findById(id).orElse(null);
        if(userFound != null)
        {
            userFound.setFirstName(user.getFirstName());
            userFound.setLastName(user.getLastName());
            userFound.setEmail(user.getEmail());
            userFound.setPassword(user.getPassword());
            this.userRepository.save(userFound);
        }
        return new MessageResponse("User updated successfully!");
    }

    // deleteUserById method
    public MessageResponse deleteUserById(int id)
    {
        this.userRepository.deleteById(id);
        return new MessageResponse("User deleted successfully!");
    }
}
