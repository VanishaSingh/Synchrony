package com.Synchrony.controller;

import com.Synchrony.entity.User;
import com.Synchrony.model.UserRegistrationRequest;
import com.Synchrony.model.UserRegistrationResponse;
import com.Synchrony.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Api(tags = "User API")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ApiOperation("Register a new user")
    public UserRegistrationResponse registerUser(@RequestBody UserRegistrationRequest request) {


        // Register the user
        User registeredUser = userService.registerUser(request);

        if (registeredUser != null) {
            // User registration was successful
            return new UserRegistrationResponse("User registered successfully");
        } else {
            // Handle registration failure
            return new UserRegistrationResponse("User registration failed");
        }
    }

    @GetMapping("/{username}")
    @ApiOperation("Get user information by username")
    public User getUser(@PathVariable User username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/authenticate")
    public UserRegistrationResponse authenticateUser(@RequestBody UserRegistrationRequest request) {
        if (userService.authenticateUser(request)) {
            return new UserRegistrationResponse("User authenticated successfully");
        } else {
            return new UserRegistrationResponse("Authentication failed");
        }
    }

}

