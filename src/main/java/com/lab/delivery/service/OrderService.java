package com.lab.delivery.service;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.domain.Order;

/**
 * Created by Mantixop on 1/21/16.
 */
public interface OrderService {
    public Order placeNewOrder(Customer customer, Integer ... pizzasID);
}
