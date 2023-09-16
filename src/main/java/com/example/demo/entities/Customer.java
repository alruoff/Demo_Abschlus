package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName; // иное, чем логин. Отдельное имя в системе

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    private Boolean is_blocked;
    private String email;
    private String position;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    // @JoinColumn(name="user_id")
    private User user;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<COrder> listOfCorders;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "techno_id")
    private List<Technology> listOfTechno;

    public Customer(String name, Boolean is_blocked, String email, String position, User user) {
        this.fullName = name;
        this.is_blocked = is_blocked;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.email = email;
        this.position = position;
        this.user = user;

        this.listOfCorders = new ArrayList<>();
        this.listOfTechno = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", is_blocked=" + is_blocked +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                // ", user=" + user +
                '}';
    }
}
//    public List<COrder> getListOfOrders() {
//        return listOfCOrders;
//    }
//
//    public void setListOfOrders(List<COrder> listOfCOrders) {
//        this.listOfCOrders = listOfCOrders;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public Boolean getIs_blocked() {
//        return is_blocked;
//    }
//
//    public void setIs_blocked(Boolean is_blocked) {
//        this.is_blocked = is_blocked;
//    }
//
//    public LocalDateTime getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(LocalDateTime created_at) {
//        this.created_at = created_at;
//    }
//
//    public LocalDateTime getUpdated_at() {
//        return updated_at;
//    }
//
//    public void setUpdated_at(LocalDateTime updated_at) {
//        this.updated_at = updated_at;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public User getUser() {
//        return user;
//    }
//}
//    @OneToMany
////    @OnDelete(action= OnDeleteAction.NO_ACTION)
////    @JoinTable (name = "technology",
////            joinColumns = @JoinColumn(name = "id"),
////            inverseJoinColumns = @JoinColumn(name = "id"))
//    private Collection<Technology> technologies = new ArrayList<>(); // набор записей в таблице

/*

        @OneToOne(fetch = FetchType.EAGER)
        @JoinTable(name = "user",
                joinColumns = @JoinColumn(name = "id"),
                inverseJoinColumns = @JoinColumn(name = "id"))


    @OneToOne(mappedBy = "customer", cascade =  // есть все, кроме REMOVE
    {
           CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
           CascadeType.REFRESH
    })
    private User user;

 */