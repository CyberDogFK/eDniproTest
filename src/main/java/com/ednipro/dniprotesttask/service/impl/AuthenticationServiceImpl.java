package com.ednipro.dniprotesttask.service.impl;

import com.ednipro.dniprotesttask.model.User;
import com.ednipro.dniprotesttask.service.AuthenticationService;
import com.ednipro.dniprotesttask.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.add(user);
        return user;
    }
}
