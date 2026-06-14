package com.stokastik.coffeeshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.stokastik.coffeeshop.exception.CoffeeNotFoundException;
import com.stokastik.coffeeshop.model.Coffee;

@Service
public class CoffeeService {
    private final List<Coffee> menu = new ArrayList<>();

    // Populate initial mock data
    public CoffeeService() {
        menu.add(new Coffee("1", "Bali Kintamani Honey", 35000.0));
        menu.add(new Coffee("2", "Gayo Espresso", 28000.0));
    }

    public List<Coffee> getAllCoffees() {
        return menu;
    }

    public Coffee getCoffeeById(String id) {
        return menu.stream()
                    .filter(coffee -> coffee.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new CoffeeNotFoundException("Coffee with ID " + id + " not found"));
    }

    public void addCoffee(Coffee coffee) {
        menu.add(coffee);
    }

    public HashMap<String, String> deleteMenuById(String id) {
        HashMap<String, String> responseMessage = new HashMap<>();
        if (!getCoffeeById(id).getId().isBlank()){
            menu.removeIf(menu -> menu.getId().equals(id));
            responseMessage.put("Status", "Sucess");
            responseMessage.put("Message", "Success delete coffee menu with ID: " + id);
            return responseMessage;
        } else {
            throw new CoffeeNotFoundException("Deletion fail: Coffee with ID " + id + " not found");
        }
    }
}
