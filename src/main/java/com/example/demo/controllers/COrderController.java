package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.COrderService;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class COrderController {

    private final COrderService corderService;
    private final UserService userService;

    @PostMapping("/neworder")
    public String createNewOrder(@RequestParam(name = "name") String orderName,
                                 @RequestParam(name = "info") String info, Principal principal) {

        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));

        corderService.createNewOrder (user.getCustomer(), orderName, info );

        return "OK";
    }
    @GetMapping("/orders")
    public String getAllOrders(Principal principal) {

        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));

        return user.getCustomer().getListOfCorders().toString();
    }
}
