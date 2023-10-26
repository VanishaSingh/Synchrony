package com.Synchrony.service;

import com.Synchrony.entity.User;
import com.Synchrony.exception.UserNotFoundException;
import com.Synchrony.exception.UserRegistrationException;
import com.Synchrony.model.UserRegistrationRequest;
import com.Synchrony.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    //private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository)  {
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationRequest request) throws UserRegistrationException {
        // Check if the username is already in use
        if (userRepository.findByUsername(request.getUsername()) != null) {
            throw new UserRegistrationException("Username is already taken");
        }

        // Create and save the new user
        User user = new User();
        user.setUsername(request.getUsername());
        //user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }



    public User getUserByUsername(User username) {
        //return userRepository.findByUsername(username.getUsername());
        User user = userRepository.findByUsername(username.getUsername());
        if (user == null) {
            throw new UserNotFoundException("User not found with username: " + username);
        }
        return user;
    }

    public boolean authenticateUser(UserRegistrationRequest request) {
        // Implement user authentication logic
        // Compare the provided password with the stored hashed password
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null) {
            // Implement password comparison logic (e.g., using BCrypt)
            return user.getPassword().equals(request.getPassword());
        }
        return false;
    }
}
