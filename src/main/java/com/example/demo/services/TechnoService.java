package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Technology;
import com.example.demo.repositories.COrderRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.TechnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TechnoService {

    private final TechnoRepository technoRepository;

    public String createNewTechno(String name,String desc, Customer cust) {

        Technology tech = new Technology(name,desc, cust);

        technoRepository.saveAndFlush(tech);

        return  "OK";
    }
}
