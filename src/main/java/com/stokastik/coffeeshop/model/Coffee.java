package com.stokastik.coffeeshop.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name should not be null or empty")
    private String name;

    @NotNull(message = "Price should not be null or empty")
    @Positive(message = "Price should not be negative value")
    private Double price;
    
    public Coffee() {
    }
    public Coffee(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
