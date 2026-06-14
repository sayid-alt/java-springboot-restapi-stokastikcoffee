package com.stokastik.coffeeshop.service;


import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.stokastik.coffeeshop.exception.CoffeeNotFoundException;
import com.stokastik.coffeeshop.model.Coffee;
import com.stokastik.coffeeshop.repository.CoffeeRepository;

@Service
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffeeById(Integer id) {
        return coffeeRepository.findById(id).orElseThrow(
            () -> new CoffeeNotFoundException("Coffee Not Found")
        );
    }

    public HashMap<String, String> addCoffee(Coffee coffee) {
        coffeeRepository.save(coffee);

        HashMap<String, String> responseStatus = new HashMap<>();
        responseStatus.put("status", "Success");
        responseStatus.put("message", "Success added new coffee");
        return responseStatus;
    }

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
