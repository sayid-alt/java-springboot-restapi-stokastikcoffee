package com.stokastik.coffeeshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stokastik.coffeeshop.model.Coffee;
import com.stokastik.coffeeshop.service.CoffeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("api/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    @GetMapping
    public ResponseEntity<List<Coffee>> getAllCoffees() {
        return new ResponseEntity<>(coffeeService.getAllCoffees(), HttpStatus.OK);
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(coffeeService.getCoffeeById(id), HttpStatus.OK);
    }

    // Get by bean
    @GetMapping("/bean")
    public ResponseEntity<List<Coffee>> getCoffeeByBean(@RequestParam String bean) {
        return new ResponseEntity<>(coffeeService.getCoffeeByBean(bean), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HashMap<String, String>> addCoffee(@Valid @RequestBody Coffee newCoffee) {
        HashMap<String, String> responseStatus = coffeeService.addCoffee(newCoffee);
        return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, String>> updateCoffee(@PathVariable Integer id, @RequestBody Coffee newCoffee) {
        return new ResponseEntity<>(coffeeService.updateCoffee(id, newCoffee), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, String>> deleteCoffee(@PathVariable Integer id) {
        return new ResponseEntity<>(coffeeService.deleteMenuById(id), HttpStatus.OK);
    }
}
