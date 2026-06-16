package com.stokastik.coffeeshop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.stokastik.coffeeshop.exception.CoffeeNotFoundException;
import com.stokastik.coffeeshop.model.Coffee;
import com.stokastik.coffeeshop.repository.CoffeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    // Get All Coffee
    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    // Get Coffee by ID
    public Coffee getCoffeeById(Integer id) {
        return coffeeRepository.findById(id).orElseThrow(
            () -> new CoffeeNotFoundException("Coffee Not Found")
        );
    }

    // Get coffees by
    public List<Coffee> getCoffeeByBean(@RequestParam String bean) {
        return coffeeRepository.findByBean(bean);
    }

    // Insert new coffee
    public HashMap<String, String> addCoffee(Coffee coffee) {
        coffeeRepository.save(coffee);

        HashMap<String, String> responseMessage = new HashMap<>();
        responseMessage.put("status", "Success");
        responseMessage.put("message", "Success added new coffee");
        return responseMessage;
    }

    // Update coffee by ID
    public HashMap<String, String> updateCoffee(Integer id, Coffee newCoffee) {
        Coffee selectedCoffee = coffeeRepository.findById(id).get();
        if (!selectedCoffee.equals(null)) {
            selectedCoffee.setName(newCoffee.getName());
            selectedCoffee.setBean(newCoffee.getBean());
            selectedCoffee.setPrice(newCoffee.getPrice());
            coffeeRepository.save(selectedCoffee);

            HashMap<String, String> responseMessage = new HashMap<>();
            responseMessage.put("status", "Success");
            responseMessage.put("message", "Success updated new coffee");
            return responseMessage;
        } else {
            throw new CoffeeNotFoundException("Update failed: Coffee not found");
        }
    }

    // Delete coffee by id
    public HashMap<String, String> deleteMenuById(Integer id) {
        if (coffeeRepository.existsById(id)) {
            coffeeRepository.deleteById(id);
            
            HashMap<String, String> responseMessage = new HashMap<>();
            responseMessage.put("status", "success");
            responseMessage.put("message", "Success delete coffe with id: " + id);
    
            return responseMessage;
        } else {
            throw new CoffeeNotFoundException("Failed to delete coffee with ID: " + id);
        }
    }
}
