package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.TechnoService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class TechnologyController {

    private final TechnoService technoService;
    private final UserService userService;
    @PostMapping("/newtechnology")
    public String createNewTechnology(@RequestParam(name="technoName") String technoName,
                                      @RequestParam(name="Description") String description,
                                      Principal principal) {

        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));

        technoService.createNewTechno(technoName, description , user.getCustomer() );

        return "OK";
}