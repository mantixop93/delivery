package com.lab.delivery.domain.discount;

import com.lab.delivery.domain.Order;

/**
 * Created by Mantixop on 2/1/16.
 */
public interface Discount {
    int makeDiscount(Order order);
}
