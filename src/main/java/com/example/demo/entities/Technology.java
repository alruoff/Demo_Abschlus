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

    @Column(name = "name", unique = true, nullable = false)
    private String name; // название технологии операций

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer author; // автор технологии

    @CreationTimestamp
    private LocalDateTime created_at; // когда создана

    @UpdateTimestamp
    private LocalDateTime updated_at; // когда вносились изменения

    @Column(name = "description", columnDefinition = "text")
    private String description; // описание типового ТЗ в виде текста

    @OneToMany(cascade = CascadeType.ALL)
    private List<COrder> listOfOrders;

    private Boolean is_active;
    public Technology(String name, String description, Customer author) {

        this.name = name;
        this.author = author;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.is_active = true;
        this.description = description;
        this.listOfOrders = new ArrayList<>();

    }

    public void addOrderToOrdersList(COrder order) {
        this.listOfOrders.add(order);
    }

    public void clearOrdersList() {
        this.listOfOrders.clear();
    }

    public void setOff() {
        this.updated_at = LocalDateTime.now();
        this.is_active = false;
    }
}
