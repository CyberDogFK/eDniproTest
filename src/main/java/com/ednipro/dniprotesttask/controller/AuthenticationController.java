package com.ednipro.dniprotesttask.controller;

import com.ednipro.dniprotesttask.dto.UserRequestDto;
import com.ednipro.dniprotesttask.dto.UserResponseDto;
import com.ednipro.dniprotesttask.model.User;
import com.ednipro.dniprotesttask.service.AuthenticationService;
import com.ednipro.dniprotesttask.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(AuthenticationService authService,
            ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.authService = authService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @GetMapping("/register")
    public ModelAndView listUploadedFiles(Model model) {
        UserRequestDto userRequestDto = new UserRequestDto();
        model.addAttribute("user", userRequestDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerForm");
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(),
                requestDto.getPassword());
        return "redirect:/";
    }
}
