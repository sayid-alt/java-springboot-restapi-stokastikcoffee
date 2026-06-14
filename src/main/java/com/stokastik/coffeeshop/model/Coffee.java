package com.stokastik.coffeeshop.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Coffee {

    @NotBlank(message = "ID cannot be blank")
    private String id;

    @NotBlank(message = "Name should not be null or empty")
    private String name;

    @NotNull(message = "Price should not be null or empty")
    @Positive(message = "Price should not be negative value")
    private Double price;
    
    public Coffee(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Coffee [getId()=" + getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
                + ", getClass()=" + getClass() + "]";
    }

    

}
