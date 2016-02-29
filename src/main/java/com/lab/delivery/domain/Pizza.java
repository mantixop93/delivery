package com.lab.delivery.domain;

import javax.persistence.*;

/**
 * Created by Mantixop on 1/21/16.
 */

@Entity
@Table(name = "pizzas")
public class Pizza {

    public enum PizzaType {
        VEGETARIAN, SEA, MEAT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private Integer id;

    @Column(name = "pizza_name")
    private String name;

    @Column(name = "pizza_price")
    private Integer price;

    @Column(name = "pizza_type")
    @Enumerated(EnumType.STRING)
    private PizzaType pizzaType;


    @Column(name = "pizza_active")
    private Boolean active;
    public Pizza() {
    }

    public Pizza(String name, Integer price, PizzaType pizzaType, Boolean active) {
        this.name = name;
        this.price = price;
        this.pizzaType = pizzaType;
        this.active = active;
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

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizzaType=" + pizzaType +
                '}';
    }
}
