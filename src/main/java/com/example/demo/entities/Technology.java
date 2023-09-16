package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Technology {

    @Id
    @GeneratedValue
    private Long id;

    private String name; // название технологии операций

    @ManyToOne (cascade = CascadeType.ALL)
    private Customer author; // автор технологии


    @CreationTimestamp
    private LocalDateTime created_at; // когда создана

    @UpdateTimestamp
    private LocalDateTime updated_at; // когда вносились изменения
    private Boolean is_active; // включить / выключить
    @Column(columnDefinition = "text")
    private String description; // описание типового ТЗ в виде текста

    @OneToMany (cascade = CascadeType.ALL)
    private List<COrder> listOfOrders;

    public Technology(String name, String description, Customer author) {

        this.name = name;
        this.author = author;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.is_active = true;
        this.description = description;
        this.listOfOrders = new ArrayList<>();

    }
}
