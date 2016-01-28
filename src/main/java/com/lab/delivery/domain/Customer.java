package com.lab.delivery.domain;

/**
 * Created by Mantixop on 1/21/16.
 */
public class Customer {

    private int id;
    private String name;
    private Address address;
    private AccumulativeCard accumulativeCard;

    public Customer(int id, String name, Address address, AccumulativeCard accumulativeCard) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accumulativeCard = accumulativeCard;
    }

    public AccumulativeCard getAccumulativeCard() {
        return accumulativeCard;
    }

    public void setAccumulativeCard(AccumulativeCard accumulativeCard) {
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
