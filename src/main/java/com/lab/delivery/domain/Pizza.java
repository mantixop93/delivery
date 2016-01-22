package com.lab.delivery.domain;

/**
 * Created by Mantixop on 1/21/16.
 */
public class Pizza {
    private Integer id;
    private String name;
    private Double price;
    private PizzaTipe pizzaTipe;

    public Pizza(Integer id, String name, Double price, PizzaTipe pizzaTipe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzaTipe = pizzaTipe;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public enum PizzaTipe {
        Vegetarian, Sea, Meat
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizzaTipe=" + pizzaTipe +
                '}';
    }
}
