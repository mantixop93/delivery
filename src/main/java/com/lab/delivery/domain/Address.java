package com.lab.delivery.domain;

import javax.persistence.*;

/**
 * Created by Mantixop on 1/28/16.
 */
@Entity(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "address_name")
    private String name;

    public Address(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
