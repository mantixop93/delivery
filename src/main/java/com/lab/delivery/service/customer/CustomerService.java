package com.lab.delivery.service.customer;

import com.lab.delivery.domain.Customer;

/**
 * Created by Mantixop on 1/28/16.
 */
public interface CustomerService {
    void addBonus(Customer customer, int bonus);
    void save(Customer customer);
}
