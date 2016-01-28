package com.lab.delivery.repository.order;

import com.lab.delivery.domain.Order;
import com.lab.delivery.repository.order.OrderRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mantixop on 1/21/16.
 */
public class InMemOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<Order>();

    public Order save(Order order) {
        orders.add(order);
        return order;
    }
}
