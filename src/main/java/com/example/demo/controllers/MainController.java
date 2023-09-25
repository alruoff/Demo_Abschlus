package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public String homePage(Principal principal) { return "Номе - current login is: " + principal.getName(); }
    @GetMapping("/authenticated")
    public String AuthPage(Principal principal) { return "Auth - current login is: " + principal.getName(); }

    @GetMapping("/usersname")
    public String findAll(Model model) {

        List<User> usrs = userService.getAllUsers();

        model.addAttribute("users", usrs);

        //List<String> list = userService.getAllUsers().forEach();
        return usrs.get(1).getLogin();
    }
}
