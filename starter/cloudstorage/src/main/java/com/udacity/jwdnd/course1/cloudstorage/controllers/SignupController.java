package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.models.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {
    private final UserService userService;

    @GetMapping
    public String getSignUp(User user, Model model) {
        return "signup";
    }

    @PostMapping
    public RedirectView postSignUp(User user, Model model) throws Exception {
        this.userService.createUser(user);
        return new RedirectView("/login");
    }
}
