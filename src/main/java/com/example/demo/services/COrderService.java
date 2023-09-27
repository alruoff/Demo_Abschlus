package com.example.demo.services;

import com.example.demo.entities.COrder;
import com.example.demo.entities.Customer;
import com.example.demo.entities.sets.BaseSet;
import com.example.demo.entities.sets.VarOfBrochureSet;
import com.example.demo.entities.sets.VarOfPlainSet;
import com.example.demo.repositories.COrderRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

    public String getOrderType(Long id) throws ParseException {

        COrder order = corderRepository.getOrderById(id);

        if (order == null) return "ERROR - wrong Order";

        JSONParser jp = new JSONParser();

        JSONObject root = (JSONObject) jp.parse(order.getInfo());

        return (String) root.get("type");
    }

    public BaseSet getOrderVars(Long id) throws ParseException {

        COrder order = corderRepository.getOrderById(id);

        Gson gson = new Gson();

        BaseSet set;

        if(getOrderType(id).equalsIgnoreCase("Брошюра")) {
            set = new VarOfBrochureSet();
        }
        else  if(getOrderType(id).equalsIgnoreCase("Листовка")) {
            set = new VarOfPlainSet();
        }
        else return null;

        return gson.fromJson(order.getInfo(), set.getClass());
    }

}
