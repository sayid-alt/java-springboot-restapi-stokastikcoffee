package com.stokastik.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stokastik.coffeeshop.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}
