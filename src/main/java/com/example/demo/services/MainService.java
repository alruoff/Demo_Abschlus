package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.entities.Technology;
import com.example.demo.entities.sets.*;
import com.example.demo.repositories.OperationARepository;
import com.example.demo.repositories.OperationBRepository;
import com.example.demo.repositories.OperationCRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor

public class MainService {

    private final OrderService orderService;
    private final TechnoService technoService;

    private final OperationARepository OpARepo;
    private final OperationBRepository OpBRepo;
    private final OperationCRepository OpCRepo;
    private final OperationBRepository OpDRepo;
    private final OperationCRepository OpERepo;
    OperationBase o1,o2,o3,o4,o5;
    Map<String, OperationBase> operationMap;

    public List<OperationBase> dispatchOrder(Long orderId) throws ParseException {

        Order order = orderService.getOrderById(orderId); // заказ со всеми атрибутами доступен
        OrderBaseSet orderBaseSet = orderService.getOrderVars(orderId); // набор переменных из Заказа
        Technology techno = order.getTechno(); // привязанная к Заказу технология
        DestrictBase destrictBase = technoService.getTechnoVars(techno.getId()); // набор параметров Технологии

        List<OperationBase> OperationList = new ArrayList<>();

        // OperationBase op = operationMap.get(destrictBase.getParts().get(2));

        Integer length = destrictBase.getParts().size(); //длина списка операций из технологии

        for (int i = 0; i < length; i++) {
            OperationList.add(operationMap.get(destrictBase.getParts().get(i)));
            OperationBase ob =  OperationList.get(i);
            System.out.println();
        }


        OperationA opA = new OperationA(); // точка останова для отладки


        return OperationList;
    }

    public void initial() {

        OperationBase o1 = new OperationA("Участок 1"); // различные операции на производстве
        OperationBase o2 = new OperationB("Участок 2");
        OperationBase o3 = new OperationC("Участок 3");
        OperationBase o4 = new OperationD("Участок 4");
        OperationBase o5 = new OperationE("Участок 5");

        operationMap = new HashMap<>();

        operationMap.put("Склад Бумаги", o1); // соответствие "названия участка" к сущности
        operationMap.put("Резка бумаги в печать", o2);
        operationMap.put("Печать CMYK", o3);
        operationMap.put("Резка продукции", o2);
        operationMap.put("Упаковка", o4);
        operationMap.put("Склад Готовой Продукции", o5);

    }
}
