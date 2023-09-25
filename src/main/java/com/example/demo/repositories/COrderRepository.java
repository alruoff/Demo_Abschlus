package com.example.demo.repositories;

import com.example.demo.entities.COrder;
import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface COrderRepository extends JpaRepository<COrder, Long> {
    public List<COrder> findAllByCustomer( Customer customer );
    COrder getOrderById(Long orderId);
}
