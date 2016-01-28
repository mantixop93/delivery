package com.lab.delivery.domain;

/**
 * Created by Mantixop on 1/28/16.
 */
public class AccumulativeCard {

    private Integer id;
    private Customer customer;
    private Integer score;

    public AccumulativeCard(Integer id, Customer customer, Integer score) {
        this.id = id;
        this.customer = customer;
        this.score = score;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
