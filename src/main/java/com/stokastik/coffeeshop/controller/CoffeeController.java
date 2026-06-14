package com.stokastik.coffeeshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stokastik.coffeeshop.model.Coffee;
import com.stokastik.coffeeshop.service.CoffeeService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService){
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public ResponseEntity<List<Coffee>> getAllCoffees() {
        return new ResponseEntity<>(coffeeService.getAllCoffees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(coffeeService.getCoffeeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HashMap<String, String>> addCoffee(@Valid @RequestBody Coffee newCoffee) {
        HashMap<String, String> responseStatus = coffeeService.addCoffee(newCoffee);
        return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, String>> deleteCoffee(@PathVariable Integer id) {
        return new ResponseEntity<>(coffeeService.deleteMenuById(id), HttpStatus.OK);
    }
}
