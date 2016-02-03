package com.lab.delivery.tools.listeners;

import com.lab.delivery.domain.Order;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Mantixop on 2/3/16.
 */
public class OrderServiceListner implements ApplicationListener<OrderCreatedEvent>{

    @Override
    public void onApplicationEvent(OrderCreatedEvent orderCreatedEvent) {
        System.out.println(orderCreatedEvent.getOrder() + " created!");
    }
}
