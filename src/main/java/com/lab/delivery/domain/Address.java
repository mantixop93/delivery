package com.lab.delivery.domain;

/**
 * Created by Mantixop on 1/28/16.
 */
public class Address {

    private Integer id;
    private String address;

    public Address(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
