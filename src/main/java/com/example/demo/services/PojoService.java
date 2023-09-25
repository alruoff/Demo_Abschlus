package com.example.demo.services;

import com.example.demo.entities.sets.Variation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


//public class PojoService {
//
//    private ObjectMapper mapper = new ObjectMapper();;
//
//    public Variation getVarType(String str) throws JsonProcessingException {
//
//        Variation type = mapper.readValue(str, Variation.class); //.orElseThrow(() -> new JsonProcessingException("unable to parse by type:"));
//        return type;
//    }
//}