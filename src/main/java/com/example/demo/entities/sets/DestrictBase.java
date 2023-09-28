package com.example.demo.entities.sets;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
public class DestrictBase { // родит класс для всех участков на производстве

    public String name; // название технологии
    public Integer length; // длина цепочки участков в данной технологии

    public LinkedList<String> parts; // массив с названиями участков
}
