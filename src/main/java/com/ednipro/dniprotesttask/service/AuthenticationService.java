package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
