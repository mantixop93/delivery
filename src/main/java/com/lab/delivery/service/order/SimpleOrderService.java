package com.lab.delivery.service.order;

import com.lab.delivery.domain.user.User;
import com.lab.delivery.domain.Order;
import com.lab.delivery.domain.Pizza;
import com.lab.delivery.domain.discount.Discount;
import com.lab.delivery.repository.order.OrderRepository;
import com.lab.delivery.service.user.UserService;
import com.lab.delivery.service.pizza.PizzaService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.lab.delivery.domain.Order.Status.*;
/**
 * Created by Mantixop on 1/21/16.
 */

@Service
public class SimpleOrderService implements OrderService, ApplicationContextAware {

    private static final double MAX_ACCUMULATIVE_DISCOUNT = 0.3d;

    private ApplicationContext applicationContext;
    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private UserService customerService;
    private Discount discount;

    @Autowired
    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, UserService customerService, Discount discount) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerService = customerService;
        this.discount = discount;
    }


    public Order placeNewOrder(User user, Integer ... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();

        for(Integer id : pizzasID){
            pizzas.add(getPizzaByID(id));
        }

        Order newOrder = new Order(1, user, pizzas, NEW);
        saveOrder(newOrder);
        return newOrder;
    }

    public Order cookOrder(Order order) {
        order.setStatus(DONE);
        return order;
    }

    public int payOrder(Order order) {
//        int price = discount.makeDiscount(order);
//        if (price * MAX_ACCUMULATIVE_DISCOUNT < order.getUser().getBonus()) {
//            price *= MAX_ACCUMULATIVE_DISCOUNT;
//        } else {
//            price = price - order.getUser().getBonus();
//        }
//        order.getUser().addToAccumulativeCard(price);
//        return price;
        return 0;
    }


    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}