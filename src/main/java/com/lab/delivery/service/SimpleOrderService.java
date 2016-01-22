package com.lab.delivery.service;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.domain.Order;
import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.InMemOrderRepository;
import com.lab.delivery.repository.OrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mantixop on 1/21/16.
 */
public class SimpleOrderService implements OrderService{

    private OrderRepository orderRepository = new InMemOrderRepository();
    private PizzaService pizzaService = new SimplePizzaService();

    public Order placeNewOrder(Customer customer, Integer ... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();

        for(Integer id : pizzasID){
            pizzas.add(getPizzaByID(id));  // get Pizza from predifined in-memory list
        }

        Order newOrder = new Order(1, customer, pizzas);

        saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }

    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

}