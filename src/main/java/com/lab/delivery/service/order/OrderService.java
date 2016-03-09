package com.lab.delivery.service.order;

import com.lab.delivery.domain.user.User;
import com.lab.delivery.domain.Order;

/**
 * Created by Mantixop on 1/21/16.
 */
public interface OrderService {
    Order placeNewOrder(User user, Integer ... pizzasID);
}
