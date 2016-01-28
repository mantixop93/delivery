package com.lab.delivery;

import com.lab.delivery.domain.Order;
import com.lab.delivery.service.OrderService;
import com.lab.delivery.tools.ApplicationContext;
import com.lab.delivery.tools.JavaConfig;
import com.lab.delivery.tools.JavaConfigApplicationContext;

/**
 * Created by Mantixop on 1/21/16.
 */

public class DeliveryApp {
    public static void main(String[] args) {
        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());

        OrderService orderService = (OrderService) context.getBean("orderService");
        Order order = orderService.placeNewOrder(null ,1, 4);

        System.out.println(order);
    }
}
