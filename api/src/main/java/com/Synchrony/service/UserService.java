package com.Synchrony.service;

import com.Synchrony.entity.User;
import com.Synchrony.exception.UserRegistrationException;
import com.Synchrony.model.UserRegistrationRequest;

public interface UserService {

    //public User registerUser(String username, String password) throws UserRegistrationException;

    User registerUser(UserRegistrationRequest user);
    public User getUserByUsername(User username);
    public boolean authenticateUser(UserRegistrationRequest request);
}
