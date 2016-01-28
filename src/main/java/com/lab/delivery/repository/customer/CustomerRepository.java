package com.lab.delivery.repository.customer;

import com.lab.delivery.domain.Customer;

/**
 * Created by Mantixop on 1/28/16.
 */
public interface CustomerRepository {
    Customer save(Customer customer);
}
