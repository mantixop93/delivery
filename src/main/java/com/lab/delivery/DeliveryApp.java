package com.lab.delivery;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.domain.Order;
import com.lab.delivery.service.SimpleOrderService;

/**
 * Created by Mantixop on 1/21/16.
 */
public class DeliveryApp {
    public static void main(String[] args) {
        Customer customer = null;
        Order order;

        SimpleOrderService orderService = new SimpleOrderService();
        order = orderService.placeNewOrder(customer, 1, 2, 3);

        System.out.println(order);
    }
}
