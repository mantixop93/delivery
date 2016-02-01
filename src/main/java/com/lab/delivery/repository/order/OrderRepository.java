package com.lab.delivery.repository.order;

import com.lab.delivery.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by Mantixop on 1/21/16.
 */


public interface OrderRepository {
    Order save(Order order);
}
