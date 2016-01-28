package com.lab.delivery.domain;

import java.util.List;

/**
 * Created by Mantixop on 1/21/16.
 */
public class Order {
    private Integer id;
    private Customer customer;
    private List<Pizza> pizzas;
    private Status status;

    public Order(Integer id, Customer customer, List<Pizza> pizzas, Status status) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", pizzas=" + pizzas +
                '}';
    }

    public enum Status {
        NEW(1),
        IN_PROGRSS(2),
        CANCELED(3),
        CLOSED(4),
        DONE(5);

        private final int value;

        private Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
