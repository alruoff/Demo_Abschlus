package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.sets.*;
import com.example.demo.entities.Technology;
import com.example.demo.repositories.TechnoRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TechnoService {

    private final TechnoRepository technoRepository;

    public String createNewTechno(String name, String desc, Customer cust) {

        Technology techno = new Technology(name, desc, cust);

        technoRepository.saveAndFlush(techno);

        return "OK";
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

    public DestrictBase getTechnoVars(Long id) throws ParseException {

        Technology techno = technoRepository.getTechnologyById(id);

        String info = techno.getDescription(); // получили JSON с параметрами технологии

        Gson gson = new Gson();

        DestrictBase db = gson.fromJson(info, DestrictBase.class); // получили заполненный переменными класс

        Map<String,OperationBase> operationMap = new HashMap<>();

        OperationBase oB = new OperationB("700x1000");
        OperationBase oA = new OperationA("640x900");



        operationMap.put("СБМ", oB );
        operationMap.put("Переплётный", oA );

        OperationBase op = operationMap.get(db.getParts().get(2));

        return db;
    }
}
