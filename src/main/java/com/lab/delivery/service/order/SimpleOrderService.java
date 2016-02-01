package com.lab.delivery.service.order;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.domain.Order;
import com.lab.delivery.domain.Pizza;
import com.lab.delivery.domain.discount.Discount;
import com.lab.delivery.repository.customer.CustomerRepository;
import com.lab.delivery.repository.order.OrderRepository;
import com.lab.delivery.service.customer.CustomerService;
import com.lab.delivery.service.pizza.PizzaService;
import java.util.ArrayList;
import java.util.List;

import static com.lab.delivery.domain.Order.*;
import static com.lab.delivery.domain.Order.Status.*;
/**
 * Created by Mantixop on 1/21/16.
 */

public class SimpleOrderService implements OrderService {

    private static final double MAX_ACCUMULATIVE_DISCOUNT = 0.3d;


    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private CustomerService customerService;
    private Discount discount;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, CustomerService customerService, Discount discount) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerService = customerService;
        this.discount = discount;
    }

    public Order placeNewOrder(Customer customer, Integer ... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();

        for(Integer id : pizzasID){
            pizzas.add(getPizzaByID(id));
        }

        Order newOrder = new Order(1, customer, pizzas, NEW);

        saveOrder(newOrder);
        return newOrder;
    }

    public Order cookOrder(Order order) {
        order.setStatus(DONE);
        return order;
    }

    public int payOrder(Order order) {
        int price = discount.makeDiscount(order);
        if (price * MAX_ACCUMULATIVE_DISCOUNT < order.getCustomer().getBonus()) {
            price *= MAX_ACCUMULATIVE_DISCOUNT;
        } else {
            price = price - order.getCustomer().getBonus();
        }
        order.getCustomer().addToAccumulativeCard(price);
        return price;
    }


    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

}