package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@NoArgsConstructor
@ToString
@Entity
public class COrder {

    @Id
    @GeneratedValue
    private Long id;

    private String name; // название заказа в дополнение к номеру

    @ManyToOne (cascade = CascadeType.ALL)
    private Customer customer; // ведущий менеджер заказа

    @Column(name = "orderVars", columnDefinition = "text")
    private String info; // набор переменных параметров и их значений для этого заказа

    private Boolean is_active;

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ManyToOne(cascade = CascadeType.ALL)
    private Technology techno; // технология, по которой будет обрабатываться заказ

    public COrder(String name, Customer customer, String info, Boolean is_active) {
        this.name = name;
        this.customer = customer;
        this.info = info;
        this.is_active = is_active;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

}

/*   @OneToOne(fetch = FetchType.EAGER)
     @JoinTable(name = "technology",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Technology technology; */

