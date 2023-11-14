package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService ;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Позволяет посмотреть текущего пользователя
     * @param principal
     * @return
     */
    @GetMapping("/view")
    public String viewTestPage(Principal principal) {

        if(principal == null) return "Need System to start";
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));
        return "authenticated: " + user.getLogin() +" as " + user.getCustomer().getPosition();
    }
}
