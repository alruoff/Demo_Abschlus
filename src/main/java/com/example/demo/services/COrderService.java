package com.example.demo.services;

import com.example.demo.entities.COrder;
import com.example.demo.entities.Customer;
import com.example.demo.repositories.COrderRepository;
import com.example.demo.entities.sets.Variation;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class COrderService {

    private final COrderRepository corderRepository;

    public COrder createNewOrder(Customer customer, String name, String info) {

        COrder corder = new COrder(name, customer, info, true);

        customer.getListOfCorders().add(corder); // новый заказ подцепился в список заказов

        // customerRepository.saveAndFlush(customer);

        corderRepository.saveAndFlush(corder);

        return corder;
    }

    public List<COrder> getAllCOrders(Customer customer) {

        return corderRepository.findAllByCustomer(customer);
    }

    public COrder getOrderById(Long orderId) {
        return corderRepository.getOrderById(orderId);
    }

    public void saveOrder(COrder corder) {
        corderRepository.saveAndFlush(corder);
    }

//    public Variation getOrderType(String str) throws JsonProcessingException {
//
//        PojoService pojoService = new PojoService();
//
//        Variation type = pojoService.getVarType(str);
//
//        return type;
//    }
}
