package com.lab.delivery.domain;

/**
 * Created by Mantixop on 1/21/16.
 */
public class Pizza {
    private Integer id;
    private String name;
    private Integer price;
    private PizzaType pizzaType;

    public Pizza(Integer id, String name, Integer price, PizzaType pizzaType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzaType = pizzaType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public enum PizzaType {
        VEGETERIAN, SEA, MEAT
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizzaTipe=" + pizzaType +
                '}';
    }
}
