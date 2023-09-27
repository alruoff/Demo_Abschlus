package com.example.demo.controllers;


import com.example.demo.entities.Customer;
import com.example.demo.entities.User;
import com.example.demo.entities.sets.BaseSet;
import com.example.demo.services.COrderService;
import com.example.demo.services.UserService;
import org.json.simple.parser.ParseException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_MANAGER')")
@RequestMapping("/order")
public class COrderController {

    private final COrderService corderService;
    private final UserService userService;

    @PostMapping("/new")
    public String createNewOrder(@RequestParam(name = "name") String orderName,
                                 @RequestParam(name = "info") String info, Principal principal) {

        User user = getUser(principal);

        corderService.createNewOrder(user.getCustomer(), orderName, info);

        return "OK";
    }

    @GetMapping("/orders")
    public List<String> getAllOrders(Principal principal) {

        User user = getUser(principal);

        Customer cust = user.getCustomer();

        return corderService.getAllCOrders(cust).stream().map(e -> {
            return "Order # " + e.getId() + " : " + e.getName();
        }).collect(Collectors.toList());
    }

    private User getUser(Principal principal) {

        return userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));
    }

    @GetMapping("/type/{id}")
    public String getOrderType(@PathVariable Long id) throws ParseException {

        return corderService.getOrderType(id);
    }

    @GetMapping("/vars/{id}")
    public BaseSet getOrderVars(@PathVariable Long id) throws ParseException {

        return corderService.getOrderVars(id);
    }

}
