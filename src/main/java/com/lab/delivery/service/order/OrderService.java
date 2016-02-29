package com.lab.delivery.service.order;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.domain.Order;
import com.lab.delivery.domain.Pizza;

/**
 * Created by Mantixop on 1/21/16.
 */
public interface OrderService {
    Order placeNewOrder(Customer customer, Integer ... pizzasID);
}
