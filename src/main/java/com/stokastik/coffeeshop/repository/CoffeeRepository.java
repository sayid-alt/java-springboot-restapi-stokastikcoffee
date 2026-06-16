package com.stokastik.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stokastik.coffeeshop.model.Coffee;
import java.util.List;


public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    List<Coffee> findByBean(String bean);
}
