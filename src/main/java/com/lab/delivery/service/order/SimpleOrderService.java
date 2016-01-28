package com.lab.delivery.service.order;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.domain.Order;
import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.customer.CustomerRepository;
import com.lab.delivery.repository.order.OrderRepository;
import com.lab.delivery.service.pizza.PizzaService;
import java.util.ArrayList;
import java.util.List;

import static com.lab.delivery.domain.Order.*;
import static com.lab.delivery.domain.Order.Status.*;
/**
 * Created by Mantixop on 1/21/16.
 */

public class SimpleOrderService implements OrderService {

    private static final int MAX_ORDER_CAPACITY = 10;
    private static final int EXPENSIVE_PIZZA_DISCOUNT = 30;
    private static final int DISCOUNT_ORDER_CAPACITY = 4;

    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private CustomerRepository customerRepository;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerRepository = customerRepository;
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

    public int addPizzasToOrder(Order order, Pizza... pizzas) {
        List orderPizzas = order.getPizzas();
        int count = 0;
        for (Pizza pizza : pizzas) {
            if (orderPizzas.size() >= MAX_ORDER_CAPACITY) {
                break;
            }
            orderPizzas.add(pizza);
            count++;
        }
        return count;
    }

    private Status setOrderStatus (Order order,Status newStatus) {
        if (newStatus == CANCELED) {
            order.setStatus(newStatus);
        } else if ((newStatus.getValue() - order.getStatus().getValue()) >= 0) {
            order.setStatus(newStatus);
        }
        return order.getStatus();
    }

    public int getOrderPrice(Order order) {
        if (order.getPizzas().size() >= DISCOUNT_ORDER_CAPACITY) {
            return getDiscountOrderPrice(order);
        } else {
            return getNormalOrderPrice(order);
        }
    }

    private int getDiscountOrderPrice(Order order) {
        int maxPizzaPrice = 0;
        for (Pizza pizza : order.getPizzas()) {
            if (maxPizzaPrice < pizza.getPrice()) {
                maxPizzaPrice = pizza.getPrice().intValue();
            }
        }
        return getNormalOrderPrice(order) - maxPizzaPrice % 100 * EXPENSIVE_PIZZA_DISCOUNT;

    }

    private int getNormalOrderPrice (Order order) {
        int price = 0;
        for (Pizza pizza : order.getPizzas()) {
            price += pizza.getPrice();
        }
        return price;
    }

    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

}