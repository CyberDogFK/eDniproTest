package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
