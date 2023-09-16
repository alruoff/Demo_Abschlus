package com.example.demo.repositories;

import com.example.demo.entities.COrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnoRepository extends JpaRepository<COrder, Long> {
}
