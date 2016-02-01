package com.lab.delivery.domain;

/**
 * Created by Mantixop on 1/21/16.
 */
public class Customer {

    private static final double MAX_BONUS = 0.1;

    private int id;
    private String name;
    private Address address;
    private Integer accumulativeCard;

    public Customer(int id, String name, Address address, Integer accumulativeCard) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accumulativeCard = accumulativeCard;
    }

    public Integer getAccumulativeCard() {
        return accumulativeCard;
    }

    public int getBonus() {
        return (int) (accumulativeCard * MAX_BONUS);
    }

    public void addToAccumulativeCard (int bonus){
        accumulativeCard += bonus;
    }

    public void withdrawFromAccumulativeCard (int discount) {
        accumulativeCard -= discount;
    }

    public void setAccumulativeCard(Integer accumulativeCard) {
        this.accumulativeCard = accumulativeCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
