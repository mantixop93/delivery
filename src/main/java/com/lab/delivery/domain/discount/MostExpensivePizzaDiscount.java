package com.lab.delivery.domain.discount;

import com.lab.delivery.domain.Order;
import com.lab.delivery.domain.Pizza;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Mantixop on 2/1/16.
 */

@Component("discount")
public class MostExpensivePizzaDiscount implements Discount {

    private static final double EXPENSIVE_PIZZA_DISCOUNT = 0.3;
    private static final int DISCOUNT_ORDER_CAPACITY = 4;

    public MostExpensivePizzaDiscount() {
    }

    public int makeDiscount(Order order) {
        List<Pizza> pizzas = order.getPizzas();
        if (pizzas.size() > DISCOUNT_ORDER_CAPACITY) {
            int maxPrice = 0;
            for (Pizza pizza : pizzas) {
                if (maxPrice < pizza.getPrice());
                    maxPrice = pizza.getPrice();
            }
            return order.getPrice() - (int) (maxPrice * EXPENSIVE_PIZZA_DISCOUNT);
        } else {
            return order.getPrice();
        }
    }
}
