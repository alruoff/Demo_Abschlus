package com.example.demo.services;

import com.example.demo.entities.COrder;
import com.example.demo.entities.Customer;
import com.example.demo.repositories.COrderRepository;
import com.example.demo.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class COrderService {

    private final COrderRepository corderRepository;
    private final CustomerRepository customerRepository;

    public COrder createNewOrder(Customer customer, String name, String info) {

        COrder corder = new COrder( name, customer, info, true );

        customer.getListOfCorders().add(corder); // новый заказ подцепил в список заказов

       // customerRepository.saveAndFlush(customer);

        corderRepository.saveAndFlush(corder);

        return corder;
    }

}
