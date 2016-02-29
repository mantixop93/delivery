package com.lab.delivery.domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mantixop on 1/21/16.
 */
@Entity
@Table(name = "customer")
public class Customer {

    private static final double MAX_BONUS = 0.1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_id", nullable = false)
    private Address address;

    @Column(name = "customer_card")
    private Integer accumulativeCard;



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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", accumulativeCard=" + accumulativeCard +
                '}';
    }
}
