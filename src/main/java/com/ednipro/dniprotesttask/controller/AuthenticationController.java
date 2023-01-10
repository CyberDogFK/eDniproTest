package com.ednipro.dniprotesttask.controller;

import com.ednipro.dniprotesttask.dto.UserRequestDto;
import com.ednipro.dniprotesttask.dto.UserResponseDto;
import com.ednipro.dniprotesttask.model.User;
import com.ednipro.dniprotesttask.service.AuthenticationService;
import com.ednipro.dniprotesttask.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(AuthenticationService authService,
            ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.authService = authService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(),
                requestDto.getPassword());
        return userDtoResponseMapper.mapToDto(user);
    }
}
