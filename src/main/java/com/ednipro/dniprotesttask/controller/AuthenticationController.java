package com.ednipro.dniprotesttask.controller;

import com.ednipro.dniprotesttask.dto.UserRequestDto;
import com.ednipro.dniprotesttask.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    @ApiOperation("Redirect user to html page with register form,"
            + " add to form attribute of UserRequestDto")
    public ModelAndView listUploadedFiles(Model model) {
        UserRequestDto userRequestDto = new UserRequestDto();
        model.addAttribute("user", userRequestDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerForm");
        return modelAndView;
    }

    @PostMapping("/register")
    @ApiOperation("Get UserRequestsDto with filled fields from register form, "
            + "and save to db")
    public String register(UserRequestDto requestDto) {
        authService.register(requestDto.getEmail(),
                requestDto.getPassword());
        return "redirect:/";
    }
}
