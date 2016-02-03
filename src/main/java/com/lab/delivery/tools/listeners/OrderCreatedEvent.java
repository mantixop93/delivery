package com.lab.delivery.tools.listeners;

import com.lab.delivery.domain.Order;
import javafx.application.Application;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Mantixop on 2/3/16.
 */
public class OrderCreatedEvent extends ApplicationEvent {

    private Order order;

    public OrderCreatedEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
