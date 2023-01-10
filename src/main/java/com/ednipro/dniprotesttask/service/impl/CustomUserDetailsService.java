package com.ednipro.dniprotesttask.service.impl;

import com.ednipro.dniprotesttask.model.User;
import com.ednipro.dniprotesttask.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String name)
            throws UsernameNotFoundException {
        User user = userService.findByEmail(name)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Can't find user with name " + name));
        UserBuilder userBuilder = withUsername(name);
        userBuilder.password(user.getPassword());
        userBuilder.authorities("USER");
        return userBuilder.build();
    }
}
