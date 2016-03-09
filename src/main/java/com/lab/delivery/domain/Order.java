package com.lab.delivery.domain;

import com.lab.delivery.domain.user.User;

import javax.persistence.*;
import java.util.List;

import static com.lab.delivery.domain.Order.Status.CANCELED;

/**
 * Created by Mantixop on 1/21/16.
 */

@Entity
@Table(name = "orders")
public class Order {

    private static final int MAX_ORDER_CAPACITY = 10;

    @Id
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_user", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name="order_pizza",
            joinColumns=@JoinColumn(name="order_id", referencedColumnName="order_id"),
            inverseJoinColumns=@JoinColumn(name="pizza_id", referencedColumnName="pizza_id"))
    private List<Pizza> pizzas;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private Status status;


    public Order(Integer id, User user, List<Pizza> pizzas, Status status) {
        this.id = id;
        this.user = user;
        this.pizzas = pizzas;
        this.status = status;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public int addPizzas(Pizza... additionalPizzas) {;
        int count = 0;
        for (Pizza pizza : additionalPizzas) {
            if (this.pizzas.size() >= MAX_ORDER_CAPACITY) {
                break;
            }
            pizzas.add(pizza);
            count++;
        }
        return count;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus (Status newStatus) {
        if (newStatus == CANCELED) {
            this.status = CANCELED;
        } else if ((newStatus.getValue() - status.getValue()) >= 0) {
            this.status = newStatus;
        }
    }

    public int getPrice () {
        int price = 0;
        for (Pizza pizza : pizzas) {
            price += pizza.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", pizzas=" + pizzas +
                ", status=" + status +
                '}';
    }

    public enum Status {
        NEW(1),
        IN_PROGRSS(2),
        CANCELED(3),
        DONE(4),
        CLOSED(5);

        private final int value;

        private Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
