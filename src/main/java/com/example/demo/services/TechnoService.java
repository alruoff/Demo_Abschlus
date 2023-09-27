package com.example.demo.services;

import com.example.demo.entities.COrder;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Technology;
import com.example.demo.entities.sets.BaseSet;
import com.example.demo.entities.sets.VarOfBrochureSet;
import com.example.demo.entities.sets.VarOfPlainSet;
import com.example.demo.repositories.COrderRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.TechnoRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TechnoService {

    private final TechnoRepository technoRepository;

    public String createNewTechno(String name,String desc, Customer cust) {

        Technology techno = new Technology(name,desc, cust);

        technoRepository.saveAndFlush(techno);

        return  "OK";
    }

    public Technology getTechnoByName(String technoName) {
        return technoRepository.getTechnologyByName(technoName);
    }

    public Technology getTechnoById(Long techId) {
        return technoRepository.getTechnologyById(techId);
    }

    public void save(Technology techno) {

        techno.setUpdated_at(LocalDateTime.now());
        technoRepository.saveAndFlush(techno);
    }
    
}
